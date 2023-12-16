package exercitiul2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper<Masina>
{
    public Masina mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        Masina masina = new Masina();
        masina.setId_(resultSet.getInt("id"));
        masina.setNumarInmatriculare_(resultSet.getString("numarInmatriculare"));
        masina.setMarca_(resultSet.getString("marca"));
        masina.setAnFabricatie_(resultSet.getInt("anulFabricatiei"));
        masina.setCuloare_(resultSet.getString("culoare"));
        masina.setNumarKilometri_(resultSet.getInt("numarKilometri"));
        return masina;
    }
}
