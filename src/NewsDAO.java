import DTO.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO extends AbstractDAO<Integer, News>{

    public static final String SQL_SELECT_ALL_NEWS = "SELECT * FROM news";

    public NewsDAO() {
        this.connector = new WrapperConnector();
    }

    @Override
    public List<News> findAll() {
        List<News> allNews = new ArrayList<>();
        Statement st = null;
        try {
            st = connector.getStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_NEWS);
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setTitle(resultSet.getString("title"));
                news.setAuthor(resultSet.getString("author"));
                news.setDate(resultSet.getString("date"));
                news.setBody(resultSet.getString("body"));
                allNews.add(news);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            this.closeStatement(st);

        }
        return allNews;
    }

    @Override
    public News findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean create(News entity) {
        return false;
    }
}
