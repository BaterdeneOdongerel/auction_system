package service;

import db.ConnectionConfiguration;
import model.user.Category;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImp implements CategoryService {
    public static void main(String args[]){
        CategoryServiceImp c = new CategoryServiceImp();
        c.delete(2);
        List<Category> cats = c.selectAll();
        for (Category cc :cats) {
            System.out.println("--->" + cc.getDesc());
        }
    }

    @Override
    public void create(Category category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO category (name, `desc`) "
                    + " VALUES (?, ?)");
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDesc());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Category selectById(int id) {
        Category category = new Category();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDesc(resultSet.getString("desc"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return category;
    }

    @Override
    public List<Category> selectAll() {
        List<Category> categories = new ArrayList<Category>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM category");

            while (resultSet.next()) {
                Category cat = new Category();
                cat.setId(resultSet.getInt("id"));
                cat.setName(resultSet.getString("name"));
                cat.setDesc(resultSet.getString("desc"));
                categories.add(cat);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return categories;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();

            preparedStatement = connection.prepareStatement("DELETE from category where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Category category, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE category set name = ? , `desc` = ? where id = ?");
            preparedStatement.setInt(3, id);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDesc());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
