package engine;

import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class QuizController {
    private List<quiz> questions = new ArrayList<>();

    public QuizController(){

    }
    @GetMapping("/api/quiz")
    public quiz getquiz(){
        return new quiz("The Java Logo", "What is depicted on the Java logo?", new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"});
    }
    @RequestMapping(value = "/api/quiz", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public feedback getfeedback(answer ans){
         if(ans.getAnswer().equals("2")){
             return new feedback(true,"Congratulations, you're right!");
         }
         else {
             return new feedback(false,"Wrong answer! Please, try again.");
         }
    }
}
