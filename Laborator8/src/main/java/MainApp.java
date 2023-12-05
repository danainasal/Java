import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lab8";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement statement = connection.createStatement();
            System.out.println("1.Adăugarea unei persoane în tabela persoane!");
            afisare_tabelaPersoane(statement, "Continutul initial al tabelei persoane:");
            Scanner s = new Scanner(System.in);
            System.out.println("Dati numele persoanei:");
            String nume = s.nextLine();
            System.out.println("Dati varsta persoanei:");
            int varsta = s.nextInt();
            if (varsta < 0 || varsta > 100) {
                throw new ExceptieVarsta("Varsta invalida!");
            }
            adaugarePersoana(connection, nume, varsta);
            afisare_tabelaPersoane(statement, "Noul continut al tabelei persoane:");
            System.out.println("2. Adăugarea unei excursii în tabela excursii!");
            System.out.println("Dati id-ul persoanei a carei excursie doriti sa o adaugati:");
            int id_persoana = s.nextInt();
            if (!ExistaPersoana(connection, id_persoana)) {
                System.out.println("Persoana nu exista, trebuie sa o adaugati!");
                return;
            } else {
                s.nextLine();
                System.out.println("Dati destinatia:");
                String destinatia = s.nextLine();
                System.out.println("Dati anul:");
                int anul = s.nextInt();
                if (anul < 2002 || anul > 2023) {
                    throw new ExceptieAnExcursie("An invalid!");
                }
                adaugareExcursie(connection, id_persoana, destinatia, anul);
                afisare_tabelaExcursii(statement, "noul continut al tabelei excursii");
            }
            System.out.println("3. Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost:");
            AfisareToatePersoaneleCuExcursiileAferente(connection);
            System.out.println("4. Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură:");
            AfisarePersNumeCititTastatura(connection, nume);
            System.out.println("5. Afișarea tuturor persoanelor care au vizitat o anumita destinație:");
            AfisarePersoaneCuDestinatie(connection);
            System.out.println("6. Afișarea persoanelor care au făcut excursii într-un an introdus:");
            AfisarePersDupaAn(connection);
            System.out.println("7. Ștergerea unei excursii:");
            System.out.println("Dati id-ul excursiei pe care doriti sa o stergeti:");
            int id_excursie = s.nextInt();
            StergereExcursie(connection, id_excursie);
            System.out.println("8. Ștergerea unei persoane (împreună cu excursiile în care a fost):");
            System.out.println("Dati id-ul pers:");
            int id_perstergere = s.nextInt();
            stergePers(connection, id_perstergere);
            connection.close();
            statement.close();
        } catch (SQLException | ExceptieVarsta | ExceptieAnExcursie e) {
            e.printStackTrace();
        }
    }

    public static void afisare_tabelaPersoane(Statement statement, String mesaj) {
        String sql = "select * from persoane";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="
                        + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugarePersoana(Connection connection, String nume, int varsta) {
        String sql = "insert into persoane(nume,varsta) values (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugareExcursie(Connection connection, int id_persoana, String destinatia, int anul) {
        String sql = "insert into excursii(id_persoana,destinatia,anul) values (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ps.setString(2, destinatia);
            ps.setInt(3, anul);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static boolean ExistaPersoana(Connection connection, int id_persoana) throws SQLException {
        String sql = "select * from persoane where id=?";
        //selectează toate coloanele din tabelul persoane unde ID-ul este egal cu id_persoana
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static void afisare_tabelaExcursii(Statement statement, String mesaj) {
        String sql = "select * from excursii";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id_persoana=" + rs.getInt(1) + ", id_excursie=" + rs.getInt(2) + ",destinatia="
                        + rs.getString(3) + ",anul=" + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AfisareToatePersoaneleCuExcursiileAferente(Connection connection) {
        try {
            String sql = "SELECT p.id, p.nume, p.varsta, e.destinatia, e.anul " +
                    "FROM persoane p " +
                    "LEFT JOIN excursii e ON p.id = e.id_persoana";
            try (Statement s = connection.createStatement();
                 ResultSet rs = s.executeQuery(sql)) {
                int id_perscurenta = -1;
                while (rs.next()) {
                    int id_persoana = rs.getInt("id");
                    //verificam daca ne-am mutat la o noua pers
                    if (id_persoana != id_perscurenta) {
                        if (id_perscurenta != -1) {
                            System.out.println();
                        }
                    }
                    id_perscurenta = id_persoana;
                    String nume = rs.getString("nume");
                    int varsta = rs.getInt("varsta");
                    String destinatia = rs.getString("destinatia");
                    int anul = rs.getInt("anul");
                    System.out.println("Id:" + id_persoana + ",Nume:" + nume + ",Varsta:" + varsta
                            + ",Destinatia:" + destinatia + ",Anul:" + anul);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void AfisareExcursiiPtPers(Connection connection, int idPersoana) {
        try {
            String query = "SELECT * FROM excursii WHERE id_persoana = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idPersoana);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int idExcursie = resultSet.getInt("id_excursie");
                        String destinatie = resultSet.getString("destinatia");
                        int an = resultSet.getInt("anul");

                        System.out.println("ID: " + idExcursie + ", Destinatie: " + destinatie + ", An: " + an);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AfisarePersNumeCititTastatura(Connection connection, String nume) {
        String sql = "select * from persoane where nume=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id_persoana = rs.getInt("id");
                    AfisareExcursiiPtPers(connection, id_persoana);
                } else {
                    System.out.println("Persoana nu exista!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void AfisarePersoaneCuDestinatie(Connection connection) {
        try {
            System.out.print("Introduceti destinatia pentru a afisa persoanele: ");
            Scanner s = new Scanner(System.in);
            String destinatie = s.next();

            String sql = "SELECT DISTINCT p.id, p.nume, p.varsta FROM persoane p " +
                    "INNER JOIN excursii e ON p.id = e.id_persoana " +
                    "WHERE e.destinatia = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, destinatie);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int idPersoana = resultSet.getInt("id");
                        String nume = resultSet.getString("nume");
                        int varsta = resultSet.getInt("varsta");
                        System.out.println("ID: " + idPersoana + ", Nume: " + nume + ", Varsta: "
                                + varsta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void AfisarePersDupaAn(Connection connection) {
        try {
            System.out.print("Introduceti anul pentru a afisa persoanele: ");
            Scanner scanner = new Scanner(System.in);
            int an = scanner.nextInt();
            String sql = "SELECT DISTINCT p.id, p.nume, p.varsta FROM persoane p " +
                    "INNER JOIN excursii e ON p.id = e.id_persoana " +
                    "WHERE e.anul = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, an);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int idPersoana = resultSet.getInt("id");
                        String nume = resultSet.getString("nume");
                        int varsta = resultSet.getInt("varsta");
                        System.out.println("ID: " + idPersoana + ", Nume: " + nume + ", Varsta: " + varsta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void StergereExcursie(Connection connection, int id_excursie) {
        String sql = "delete from excursii where id_excursie=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_excursie);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de modificare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void stergePers(Connection connection, int personId) {
        try {
            String stergerepers = "DELETE FROM persoane WHERE id = ?";
            String stergereex = "DELETE FROM excursii WHERE id_persoana = ?";

            try (PreparedStatement stergerepersoana = connection.prepareStatement(stergerepers);
                 PreparedStatement stergereexcursie = connection.prepareStatement(stergereex)) {
                connection.setAutoCommit(false);
                stergereexcursie.setInt(1, personId);
                stergereexcursie.executeUpdate();
                stergerepersoana.setInt(1, personId);
                stergerepersoana.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class ExceptieVarsta extends Exception {
        public ExceptieVarsta(String mesaj) {
            super(mesaj);
        }
    }

    static class ExceptieAnExcursie extends Exception {
        public ExceptieAnExcursie(String message) {
            super(message);
        }
    }
}


