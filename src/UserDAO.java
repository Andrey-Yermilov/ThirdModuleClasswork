import DTO.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {

    public static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE email=?";

    public UserDAO() {
        this.connector = new WrapperConnector();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    public User findUserByLogin(String login) {
        User user = null;
        PreparedStatement st = null;
        try {
            st = connector.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            st.setString(1, login);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            this.closeStatement(st);

        }
        System.out.println(user);
        return user;
    }

    public static boolean checkUser(String login, String pass) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findUserByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(pass))
                return true;
            else return false;
        } else return false;
    }

}
