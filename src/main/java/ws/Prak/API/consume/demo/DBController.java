/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.Prak.API.consume.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PAVILION GAMING
 */
@CrossOrigin
@RestController
@RequestMapping("/datamhs")
public class DBController {
    
    @Autowired
    RepoMhs repomhs;
    
    @PostMapping("/addmhs")
    public Datamhsti addmhs(@RequestBody Datamhsti Param){
        repomhs.save(Param);
        return Param;
    }
    
    @GetMapping("/allmhs")
    public List<Datamhsti> allmhs(){
        return repomhs.findAll();
    }
    @PutMapping("/updatemhs")
    public Datamhsti updatemhs(@RequestBody Datamhsti Param){
        return repomhs.save(Param);
    }
    @DeleteMapping("/hapusmhs")
    public List<Datamhsti> hapusmhs(@RequestParam String id){
        repomhs.deleteById(id);
        List<Datamhsti> datalist = repomhs.findAll();
        return datalist;
    }

}
