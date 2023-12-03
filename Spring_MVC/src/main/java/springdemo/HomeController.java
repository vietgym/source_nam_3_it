package springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showFruits(Model model) {
        List<fruit> fruits = getFruitsFromDatabase();
        model.addAttribute("fruits", fruits);
        return "hello";
    }

    private List<fruit> getFruitsFromDatabase() {
        List<fruit> fruits = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM fruit_tbl";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    fruit fruit = new fruit(id, name);
                    fruits.add(fruit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fruits;
    }
}
