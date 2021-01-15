package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entiy.Inf;
import entiy.Point;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {


    public String getPoints() throws JsonProcessingException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ObjectMapper objectMapper = new ObjectMapper();
        List<Point> pointList = new ArrayList<>();

        String sql = "select * from nice_ride_2016_station_locations";
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {

                Point point = new Point();
                point.setLatitude(rs.getDouble("Latitude"));
                point.setLongitude(rs.getDouble("Longitude"));
                pointList.add(point);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        String jsonStr = objectMapper.writeValueAsString(pointList);
        System.out.println(jsonStr);
        return jsonStr;
    }

    public String getInf() throws JsonProcessingException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ObjectMapper objectMapper = new ObjectMapper();
        List<Inf> infList = new ArrayList<>();

        String sql = "select * from nice_ride_2016_station_locations";
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {

                Inf inf = new Inf();
                inf.setTerminal(rs.getString("Terminal"));
                inf.setLatitude(rs.getDouble("Latitude"));
                inf.setLongitude(rs.getDouble("Longitude"));
                inf.setText(rs.getString("Station"));
                infList.add(inf);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        String jsonStr = objectMapper.writeValueAsString(infList);
        System.out.println(jsonStr);
        return jsonStr;

    }

    public int addInf(Inf inf) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into nice_ride_2016_station_locations(Terminal, Station, Latitude, Longitude) values (?,?,?,?)";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,inf.getTerminal());
            ps.setString(2,inf.getText());
            ps.setDouble(3,inf.getLatitude());
            ps.setDouble(4,inf.getLongitude());

            int ret = ps.executeUpdate();
            return ret;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return 0;//添加失败
    }

}
