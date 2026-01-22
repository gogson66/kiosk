/*package kiosk.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import kiosk.Taco;
import kiosk.Ingredient;


@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient: taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }

        return taco;

    }

    private long saveTacoInfo(Taco taco) {

        taco.setCreatedAt(Instant.now());
        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory("insert into Taco (name, createdAt) values (?, ?)", 
        Types.VARCHAR, 
        Types.TIMESTAMP);
        factory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = factory.newPreparedStatementCreator(Arrays.asList(taco.getName(), Timestamp.from(taco.getCreatedAt())));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);

        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)", tacoId, ingredient.getId());
    }
    
}*/
