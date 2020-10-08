package kino.xp.project.repositories;

import kino.xp.project.DBConnection;
import kino.xp.project.Model.Schedule;
import kino.xp.project.Model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jonas, Jonathan
 * @Parameter repo for metoder relateret afhenting af schedule date
 * @Output håndterer data fra db
 **/

public class ScheduleRepository
{

    private Connection connection;

    public ScheduleRepository() {
        this.connection = DBConnection.getDatabaseConnection();
    }

    public List<Schedule> readScheduleByWeek(int weekNr)
    {
        List<Schedule> scheduleList = new ArrayList();
        try{
            String getById = "SELECT * FROM schedule WHERE weekNr=?";
            PreparedStatement statement = connection.prepareStatement(getById);
            statement.setInt(1, weekNr);
            ResultSet results = statement.executeQuery();
            while(results.next()){
                Schedule tempSched = new Schedule();
                tempSched.setId(results.getInt(1));
                tempSched.setWeekNr(results.getInt(2));
                tempSched.setDayNr(results.getInt(3));
                tempSched.setWorker1_id(results.getInt(4));
                tempSched.setWorker2_id(results.getInt(5));
                tempSched.setMovieO_id(results.getInt(6));
                tempSched.setTicketO_id(results.getInt(7));
                scheduleList.add(tempSched);
            }
        }
        catch (SQLException e){
            System.out.println("error at ScheduleRepository, readScheduleByWeek()");
            System.out.println(e.getMessage());
        }
        return scheduleList;
    }

    public boolean addSale1(int weekNr, int dayNr, int id)
    {

        try {
            String tempPrimStr = weekNr + "" + dayNr;
            int tempPrim = Integer.parseInt(tempPrimStr);
            String insertString = "UPDATE schedule SET worker1_id=? WHERE schedule_id=?";
            PreparedStatement statement = connection.prepareStatement(insertString);
            statement.setInt(1,id);
            statement.setInt(2,tempPrim);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("error at addSale1() ScheduleRepository");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addSale2(int weekNr, int dayNr, int id)
    {

        try {
            String tempPrimStr = weekNr + "" + dayNr;
            int tempPrim = Integer.parseInt(tempPrimStr);
            String insertString = "UPDATE schedule SET worker2_id =? WHERE schedule_id=?";
            PreparedStatement statement = connection.prepareStatement(insertString);
            statement.setInt(1,id);
            statement.setInt(2,tempPrim);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("error at addSale2() ScheduleRepository");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addMovieO(int weekNr, int dayNr, int id)
    {

        try {
            String tempPrimStr = weekNr + "" + dayNr;
            int tempPrim = Integer.parseInt(tempPrimStr);
            String insertString = "UPDATE schedule SET movieO_id =? WHERE schedule_id=?";
            PreparedStatement statement = connection.prepareStatement(insertString);
            statement.setInt(1,id);
            statement.setInt(2,tempPrim);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("error at addMovieO() ScheduleRepository");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addTicketO(int weekNr, int dayNr, int id)
    {

        try {
            String tempPrimStr = weekNr + "" + dayNr;
            int tempPrim = Integer.parseInt(tempPrimStr);
            String insertString = "UPDATE schedule SET ticketO_id =? WHERE schedule_id=?";
            PreparedStatement statement = connection.prepareStatement(insertString);
            statement.setInt(1,id);
            statement.setInt(2,tempPrim);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("error at addTicketO() ScheduleRepository");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Map<Integer, String> readAllWorkers()
    {
        Map<Integer, String> map = new HashMap();
        try{
            String selectAll = "SELECT * FROM workers";
            PreparedStatement statement = connection.prepareStatement(selectAll);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                Worker tempWork = new Worker();

                tempWork.setId(results.getInt(1));
                tempWork.setName(results.getString(2));
                map.put(tempWork.getId(), tempWork.getName());
            }
        }
        catch (SQLException e){
            System.out.println("Error at ScheduleRepository, readAllWorkers()");
            System.out.println(e.getMessage());
        }
        return map;
    }

    public List<Worker> readAllWorkersList()
    {
        List<Worker> list = new ArrayList();
        try{
            String selectAll = "SELECT * FROM workers";
            PreparedStatement statement = connection.prepareStatement(selectAll);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                Worker tempWork = new Worker();

                tempWork.setId(results.getInt(1));
                tempWork.setName(results.getString(2));
                list.add(tempWork);
            }
        }
        catch (SQLException e){
            System.out.println("Error at ScheduleRepository, readAllWorkersList()");
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int create(Worker worker)
    {
        int workerId = -1;
        try {
            String insertString = "INSERT INTO workers (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(insertString);
            statement.setString(1,worker.getName());
            statement.executeUpdate();

            //gets last customer Id used for tests
            String getLastInsertedId = "SELECT worker_id FROM workers WHERE worker_id=(SELECT LAST_INSERT_ID())";
            PreparedStatement statement1 = connection.prepareStatement(getLastInsertedId);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()){
                workerId = resultSet.getInt(1);
            }
            return workerId;
        }
        catch (SQLException e){
            System.out.println("error at create() ScheduleRepository");
            System.out.println(e.getMessage());
        }
        return workerId;
    }

    public boolean delete(int id)
    {
        String deleteString = "DELETE FROM workers WHERE worker_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(deleteString);
            statement.setInt(1,id);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println("error : ScheduleRepository delete()");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
