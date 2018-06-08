package com.capstone.swimServer.Controller;

import com.capstone.swimServer.Dao.AsnDao;
import com.capstone.swimServer.Model.Asn;
import com.capstone.swimServer.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;
    @Autowired
    private AsnDao asnDao;

//    @RequestMapping("/")
//    public @ResponseBody Iterable<Asn> getAsn(){
//        return asnDao.getASN();
//    }

    @CrossOrigin
    @RequestMapping(value = "/receiveAsn", method= RequestMethod.POST)
    public void insertAsn(@RequestBody Asn asn) {
        service.insertAsnSerial(asn);
    }

    @CrossOrigin
    @RequestMapping(value = "/getSerial", method= RequestMethod.POST)
    public @ResponseBody List getSerial(@RequestBody Asn str) {
        System.out.println(str.getAsn());
        return asnDao.getSerial(str);
    }

    @CrossOrigin
    @RequestMapping(value = "/statusChange", method= RequestMethod.POST)
    public void statusChange(@RequestBody Asn asn){
        service.updateASN(asn);
    }

    @CrossOrigin
    @RequestMapping(value = "/getReceivedList", method = RequestMethod.GET)
    public @ResponseBody List getReceivedList(){
        return asnDao.getReceivedList();
    }

}
