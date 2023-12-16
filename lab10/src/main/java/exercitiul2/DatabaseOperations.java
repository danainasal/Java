package exercitiul2;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseOperations
{
    public void setDataSource(DataSource dataSource)
    {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
}
    public void insert(Masina masina)
    {
        String SQL = "insert into masini (numarInmatriculare, marca, anulFabricatiei, culoare, numarKilometri) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, masina.getNumarInmatriculare_(), masina.getMarca_(),
                masina.getAnFabricatie_(), masina.getCuloare_(), masina.getNumarKilometri_());
    }

    public void delete(int id)
    {
        String SQL = "delete from masini where id = ?";
        jdbcTemplateObject.update(SQL, id);
    }

    public Masina get(String marca)
    {
        String SQL = "SELECT * FROM masini WHERE marca = ?";
        Masina masina = jdbcTemplateObject.queryForObject(SQL,new Object[]{marca}, new MasinaMapper());
        return masina;
    }

    public int getNumarMasiniWithUnder1000KM()
    {
        String SQL = "SELECT * FROM masini WHERE numarKilometri < 1000";
        List<Masina> masini = jdbcTemplateObject.query(SQL,new MasinaMapper());
        return masini.size();
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
}
