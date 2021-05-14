package com.example.starbucksapi;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Optional;
import java.time.*; 
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;

import com.example.springcybersource.*;
import com.example.StarbucksModel.PaymentModel;
import com.example.StarbucksRepository.PaymentRepository;


@Slf4j
@Controller
@RequestMapping("/")
public class PaymentsController {  

    @Autowired
    private PaymentRepository repository;

    private static boolean DEBUG = true;

    @Value("${cybersource.apihost}") String apihost;
    @Value("${cybersource.merchantkeyid}") String merchantkeyid;
    @Value("${cybersource.merchantsecretkey}") String merchantsecretkey;
    @Value("${cybersource.merchantid}") String merchantid;

    private CyberSourceAPI api = new CyberSourceAPI();

    @GetMapping
    public String getAction( @ModelAttribute("command") PaymentsCommand command, 
                            Model model) {

        /* Render View */

        return "CardsPage" ;

    }

    @PostMapping
    public String postAction(@Valid @ModelAttribute("command") PaymentsCommand command,  
                            @RequestParam(value="action", required=true) String action,
                            Errors errors, Model model, HttpServletRequest request) {
    
        log.info( "Action: " + action ) ;
        log.info( "Command: " + command ) ;

        PaymentModel p = new PaymentModel();
        CyberSourceAPI.setHost(apihost);
        CyberSourceAPI.setKey(merchantkeyid);
        CyberSourceAPI.setSecret(merchantsecretkey);
        CyberSourceAPI.setMerchant(merchantid);

        CyberSourceAPI.debugConfig();

        String fn = request.getParameter("firstname");
        String ln = request.getParameter("lastname");
        String adr = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String pn = request.getParameter("phonenumber");
        String cn = request.getParameter("cardnumber");
        String em = request.getParameter("expmonth");
        String ey = request.getParameter("expyear");
        String cvv = request.getParameter("cvv");
        String email = request.getParameter("email");

        System.out.println("1234");

        boolean hasErrors = false;
        if(fn.equals("")){hasErrors = true; model.addAttribute( "message", "First Name Required");}
        if(ln.equals("")){hasErrors = true; model.addAttribute( "message", "Last Name Required");}
        if(adr.equals("")){hasErrors = true; model.addAttribute( "message", "Address Required");}
        if(city.equals("")){hasErrors = true; model.addAttribute( "message", "City Required");}
        if(state.equals("")){hasErrors = true; model.addAttribute( "message", "State Required");}
        if(zip.equals("")){hasErrors = true; model.addAttribute( "message", "Zip Required");}
        if(pn.equals("")){hasErrors = true; model.addAttribute( "message", "Phone Number Required");}
        if(cn.equals("")){hasErrors = true; model.addAttribute( "message", "Card Number Required");}
        if(em.equals("")){hasErrors = true; model.addAttribute( "message", "Card Expiration Month Required");}
        if(ey.equals("")){hasErrors = true; model.addAttribute( "message", "Card Expiration Year Required");}
        if(cvv.equals("")){hasErrors = true; model.addAttribute( "message", "CVV Required");}
        if(email.equals("")){hasErrors = true; model.addAttribute( "message", "Email Required");}
        


        String pattern = "[(][0-9]{3}[)] [0-9]{3}-[0-9]{4}";
        Pattern p1 = Pattern.compile(pattern);
        Matcher m1 = p1.matcher(pn);

        String pattern2 = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
        Pattern p2 = Pattern.compile(pattern2);
        Matcher m2 = p2.matcher(cn);

        String[] arr = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        List<String> month = Arrays.asList(arr);

        String[] arr2 = new String[]{"AL","AK","AS","AZ","AR","CA","CO","CT","DE","DC","FL","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","MP","OH","OK","OR","PA","PR","RI","SC","SD","TN","TX","UT","VT","VA","VI","WA","WV","WI","WY"};
        List<String> stateArr = Arrays.asList(arr2);

        if(!zip.matches("\\d{5}")){
            hasErrors = true;
            model.addAttribute( "message", "Invalid zip");
        }
        
        if(!m1.matches()){
            hasErrors = true;
            model.addAttribute( "message", "Invalid phone numeber");
        }

        if(!m2.matches()){
            hasErrors = true;
            model.addAttribute( "message", "Invalid card numeber");
        }

        if(!month.contains(em)){
            hasErrors = true; 
            model.addAttribute( "message", "Invalid exp month");
        }

        if(!stateArr.contains(state)){
            hasErrors = true; 
            model.addAttribute( "message", "Invalid State");
        }

        if(!ey.matches("\\d{4}")){
            hasErrors = true;
            model.addAttribute( "message", "Invalid exp year");
        }

        if(!cvv.matches("\\d{3}")){
            hasErrors = true;
            model.addAttribute( "message", "Invalid cvv");
        }

        if(hasErrors){
            model.addAttribute("messages", "Invalid Input");
            System.out.println(request.getParameter("firstname"));
        }
        
        /* Render View */
        // model.addAttribute( "message", "Hello There Again!" ) ;

        int min = 1239871;
        int max = 9999999;
        int ram = (int) Math.floor(Math.random()*(max-min+1)+min);
        String orderNum = String.valueOf(ram);
        AuthRequest auth = new AuthRequest();
        auth.reference = orderNum;
        auth.billToFirstName = fn;
        auth.billToLastName = ln ;
        auth.billToAddress = adr ;
        auth.billToCity = city ;
        auth.billToState = state ;
        auth.billToZipCode = zip ;
        auth.billToPhone = pn ;
        auth.billToEmail = email ;
        auth.transactionAmount = "33.00" ;
        auth.transactionCurrency = "USD" ;
        auth.cardNumnber = cn ;
        auth.cardExpMonth = em ;
        auth.cardExpYear = ey ;
        auth.cardCVV = cvv ;
        auth.cardType = CyberSourceAPI.getCardType(auth.cardNumnber) ;
        if(auth.cardType.equals("ERROR")){
            System.out.println("Unsupported Credit Card Type");
            model.addAttribute("message", "Unsupported Credit Card Type");
            return "CardsPage";
        }
        boolean authValid = true ;
        AuthResponse authResponse = new AuthResponse() ;
        System.out.println("\n\nAuth Request: " + auth.toJson() ) ;
        authResponse = api.authorize(auth) ;
        System.out.println("\n\nAuth Response: " + authResponse.toJson() ) ;
        
        if ( !authResponse.status.equals("AUTHORIZED") ) {
            authValid = false;
            System.out.println(authResponse.message);
            model.addAttribute("message", authResponse.message);
            return "CardsPage";
        }
        boolean captureValid = true ;
        CaptureRequest capture = new CaptureRequest() ;
        CaptureResponse captureResponse = new CaptureResponse() ;
        if ( authValid ) {
            capture.reference = orderNum ;
            capture.paymentId = authResponse.id ;
            capture.transactionAmount = "33.00" ;
            capture.transactionCurrency = "USD" ;
            System.out.println("\n\nCapture Request: " + capture.toJson() ) ;
            captureResponse = api.capture(capture) ;
            System.out.println("\n\nCapture Response: " + captureResponse.toJson() ) ;
            
            if ( !captureResponse.status.equals("PENDING") ) {
                captureValid = false;
                System.out.println(captureResponse.message);
                model.addAttribute("message", captureResponse.message);
                return "CardsPage";
            }

        }

        if(authValid && captureValid){

            p.setFirstName(fn);
            p.setLastName(ln);
            p.setAddress(adr);
            p.setCity(city);
            p.setState(state);
            p.setZip(zip);
            p.setPhoneNumber(pn);
            p.setCardNumber(cn);
            p.setExpMonth(em);
            p.setExpYear(ey);
            p.setCvv(cvv);
            p.setEmail(email);

            p.setOrderNumber(orderNum);
            p.setTransactionAmount("30");
            p.setTransactionCurrency("USD");
            p.setAuthId(authResponse.id);
            p.setAuthStatus(authResponse.status);
            p.setCaptureId(captureResponse.id);
            p.setCaptureStatus(captureResponse.status);

            repository.save(p);

            System.out.println("Payment succuess order number: " + orderNum);
            model.addAttribute("message", "Thank you for your payment, your order number is " + orderNum);
        }


        if (errors.hasErrors()) {
            return "CardsPage";
        }

        return "CardsPage";
    }

}