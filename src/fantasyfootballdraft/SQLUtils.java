/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Vinnie
 */
public class SQLUtils {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private PreparedStatement preparedStatement = null;
  
    public SQLUtils(){
        try{
            connectToDataBase();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void connectToDataBase() throws Exception{
	  try {
	      Class.forName("org.postgresql.Driver");
              String url = "jdbc:postgresql://0.0.0.0:5432/postgres";
              Properties props = new Properties();
              props.setProperty("user","postgres");
              props.setProperty("password","postgres");
              connect = DriverManager.getConnection(url, props);
	      statement = connect.createStatement();
	  }
	  catch(Exception e){
		  throw e;
	  }
	  finally{
		  //close();
	  }
  }
  public ResultSet readDataBase() throws Exception {
    
      // resultSet gets the result of the SQL query
      resultSet = statement
              .executeQuery("select p.name as name, p.position as position, p.bye_week as byeWeek, t.name as teamName "
                      + "from fantasy_football.players p "
                      + "join fantasy_football.teams t "
                      + "on t.id = p.team_id "
                      + "order by p.name asc");
      
      return resultSet;
  }
  
  public ResultSet readTeamsDataBase() throws Exception {
      // resultSet gets the result of the SQL query
      return statement.executeQuery("select * from fantasy_football.teams");
  }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
  
  public void executeSelect() throws SQLException{
	  resultSet = statement.executeQuery("select * from test.players");
  }
    
  // you need to close all three to make sure
  private void close() throws SQLException {
	  resultSet.close();
	  statement.close();
	  connect.close();
  }
}
