package com.in28minutes.springboot.myfirstwebapp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("name")
@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String login(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    // Ye method user ka username return karta hai
    private String getLoggedinUsername() {

//        Authentication object: Yeh user ki authentication details ko represent karta hai. Hum SecurityContext se yeh details lete hain.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication object se user ka naam (username) return kar rahe hain
        return authentication.getName();
    }

//    private AuthenticationService authenticationService;
//    // Logger Initialization
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
////        @ResponseBody
//    @RequestMapping(path="/login", method= RequestMethod.GET)
//    public String gotoLoginPage() {
//        return "login";
//    }
//
//    @RequestMapping(path="/login", method=RequestMethod.POST)
//    public String goToLoginPage(@RequestParam String name, @RequestParam String password, ModelMap model){
//        // Note: String var name i.e name and password are same as the name attribute of form.
//
//        if(authenticationService.authenticate(name, password)){
//            // Model ke through transferred data bhi request scope me aata hai.
//            model.put("name", name); // can only be accessed by listToDos view and no other page.
//            return "welcome";
//        }
//        model.put("error", "Invalid username or password");
//        return "login";
//    }
}
