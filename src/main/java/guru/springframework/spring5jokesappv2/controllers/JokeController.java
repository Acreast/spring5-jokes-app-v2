package guru.springframework.spring5jokesappv2.controllers;


import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    //@Autowired not necessary, single parameter constructor DI will be handled by spring
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }


    //When we have a request coming in to the root of the context
    //This will be invoked
    @RequestMapping({"/",""})
    public String showJoke(Model model){ //Model is passed from the spring mvc

        model.addAttribute("joke", jokeService.getJoke()); //appending a joke from the jokes services to the property of joke

        return "index";

    }




}
