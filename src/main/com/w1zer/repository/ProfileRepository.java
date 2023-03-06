package main.com.w1zer.repository;

import main.com.w1zer.entity.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRepository {
    private final String SELECT_BY_ID_QUERY = "SELECT id, login, password FROM profile WHERE id = ?;";
    private final String INSERT_QUERY = "INSERT INTO profile (login, password) VALUES (?, ?);";
    private final String DELETE_QUERY = "DELETE FROM profile WHERE id = ?;";
    private final String UPDATE_QUERY = "UPDATE profile SET login = ?, password = ? WHERE id = ?";
    private final ConnectionFactory connectionFactory;

    public ProfileRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Profile getById(long id) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Profile profile = new Profile();
                profile.setId(resultSet.getLong("id"));
                profile.setLogin(resultSet.getString("login"));
                profile.setPassword(resultSet.getString("password"));
                return profile;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Profile profile) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, profile.getLogin());
            statement.setString(2, profile.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Profile profile) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, profile.getLogin());
            statement.setString(2, profile.getPassword());
            statement.setLong(3, profile.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
