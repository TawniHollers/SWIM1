package com.capstone.swimServer.Dao;

import com.capstone.swimServer.Model.Asn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsnDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    private final String getAsnStatus = "SELECT status FROM warehouse WHERE asn = ?";
    private final String insertAsn= "INSERT INTO warehouse VALUES(?,?,?,?,?,?)";
    private final String insertSerial= "INSERT INTO itemizedAsn VALUES(?,?,?)";
    private final String getSerialQuery = "SELECT serial FROM itemizedAsn WHERE asn = ?";

//    private final String updateDockDoorQuery = "UPDATE warehouse SET dockDoor = ? WHERE asn = ?";

//    public List getASN(){
//        List<Asn> AsnList = jdbcTemplate.query(getASNQuery, new BeanPropertyRowMapper<>(Asn.class));
//        return AsnList;
//    }

    public void insertAsn(Asn asn){
        jdbcTemplate.update(insertAsn, asn.getAsn(), asn.getVendorId(), asn.getExpectedArrivalDate(), asn.getExpectedArrivalTime(), "IN TRANSIT", null);
    }

    public void insertSerial(int asn, int serial){
        jdbcTemplate.update(insertSerial, asn, serial, null);
    }

    public List getSerial(String asn){
        List serials = jdbcTemplate.queryForList(getSerialQuery, asn);
        return serials;
    }

}