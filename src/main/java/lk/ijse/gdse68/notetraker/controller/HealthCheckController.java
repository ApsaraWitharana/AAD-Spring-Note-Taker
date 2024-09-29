package lk.ijse.gdse68.notetraker.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthTest")
@RequiredArgsConstructor
public class HealthCheckController {
    @GetMapping
    public String healthTest(){
        return "Note controller run successfully!!";

        //this is use to end point check //get req ekk withryi denn ona //application ek run wenwad blnn
        //controller ekkt wada tiyenwanm health check dann ona
        //req-http://localhost:8080/note/api/v1/notes/health
        //resp=Note traker is running
    }
}
