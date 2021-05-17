package com.example.starbucksapi;

import java.util.List;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;

import com.example.StarbucksModel.StarbucksOrder;
import com.example.StarbucksRepository.StarbucksOrderRepository;

@Controller
public class StarbucksOrderController {
    
    private final StarbucksOrderRepository repository;

    class Message {
        private String status;

        public String getStatus(){
            return status;
        }
        public void setStatus(String msg) {
            status = msg;
        }
    }

    private HashMap<String, StarbucksOrder> orders = new HashMap<>();

    public StarbucksOrderController(StarbucksOrderRepository repository) {
        this.repository = repository;
    }

    // get list of starbucks orders
    @GetMapping("/orders")
    List<StarbucksOrder> all() {
        return repository.findAll();
    }

    // delete all starbucks orders
    @DeleteMapping("/orders")
    Message deleteAll() {
        repository.deleteAllInBatch();
        orders.clear();
        Message msg = new Message();
        msg.setStatus("All Orders Cleared!");
        return msg;
    }

    // create a new starbucks order
    @PostMapping("/order/register/{regid}")
    @ResponseStatus(HttpStatus.CREATED)
    public String newOrder(@PathVariable("regid") String regid, Model model, StarbucksOrder order) {
        // Random random = new Random();
        // int regid = random.nextInt(90000)+10000;
        

        // check input
        if (order.getDrink().equals("") || order.getMilk().equals("") || order.getSize().equals("")) {
            System.out.println("Invalid requests!");
            return "OrderPage";
        }

        // check for active order
        StarbucksOrder active = orders.get(regid);
        if (active != null) {
            System.out.println("Active Order (Reg ID = " + regid + ") => " + active);
            if (active.getStatus().equals("Ready for Payment.")){
                model.addAttribute("message", "the order exist");
                return "OrderPage";
            }
        }

        // set price
        double price = 0.0;
        switch (order.getDrink()) {
            case "Espresso":
            switch (order.getSize()) {
                case "Solo":
                    price = 1.95;
                    break;
                case "Doppio":
                    price = 2.45;
                    break;
                default:
                    System.out.println("Invalid size!");
                    return "OrderPage";
            }
            break;
            case "Caffe Americano":
                switch (order.getSize()) {
                    case "Tall":
                        price = 2.55;
                        break;
                    case "Grande":
                        price = 2.95;
                        break;
                    case "Venti":
                        price = 3.35;
                        break;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            case "Caffe Latte":
                switch (order.getSize()) {
                    case "Tall":
                        price = 3.45;
                        break;
                    case "Grande":
                        price = 3.95;
                        break;
                    case "Venti":
                        price = 4.45;
                        break;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            case "Caffe Mocha":
                switch (order.getSize()) {
                    case "Tall":
                        price = 3.95;
                        break;
                    case "Grande":
                        price = 4.45;
                        break;
                    case "Venti":
                        price = 4.95;
                        break;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            case "Cappuccino":
                switch (order.getSize()) {
                    case "Tall":
                        price = 3.45;
                        break;
                    case "Grande":
                        price = 3.95;
                        break;
                    case "Venti":
                        price = 4.45;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            case "Caramel Macchiato":
                switch (order.getSize()) {
                    case "Tall":
                        price = 4.25;
                        break;
                    case "Grande":
                        price = 4.75;
                        break;
                    case "Venti":
                        price = 4.95;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            case "Iced Coffee":
                switch (order.getSize()) {
                    case "Tall":
                        price = 2.65;
                        break;
                    case "Grande":
                        price = 2.95;
                        break;
                    case "Venti":
                        price = 3.25;
                    default:
                        System.out.println("Invalid size!");
                        return "OrderPage";
                }
                break;
            default:
            System.out.println("Invalid Drink!");
            return "OrderPage";
        }
        double tax = 0.0725;
        double total = price + (price * tax);
        double scale = Math.pow(10, 2);
        double rounded = Math.round(total * scale) / scale;
        order.setTotal(rounded);
        // save order
        order.setStatus("Ready for Payment.");
        StarbucksOrder new_order = repository.save(order);
        orders.put(regid, new_order);
        model.addAttribute("message", "The order was created successfully.");
        model.addAttribute("drink", order.getDrink());
        model.addAttribute("milk", order.getMilk());
        model.addAttribute("size", order.getSize());
        model.addAttribute("total", order.getTotal());
        // model.addAttribute("register", regid);
        model.addAttribute("status", order.getStatus());
        System.out.println("Placing Order (Reg ID = " + regid + ") +> " + order);
        return "OrderPage";
    }

    // get details of a starbucks order
    @GetMapping("/order/register/{regid}")
    StarbucksOrder getActiveOrder(@PathVariable String regid, HttpServletResponse response) {
        StarbucksOrder active = orders.get(regid);
        if (active != null) {
            return active;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Not Found!");
        }
    }

    // clear active order
    @DeleteMapping("/order/register/{regid}")
    Message deleteActiveOrder(@PathVariable String regid) {
        StarbucksOrder active = orders.get(regid);
        if (active != null) {
            orders.remove(regid);
            Message msg = new Message();
            msg.setStatus("Active Order Cleared!");
            return msg;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Not Found!");
        }
    }
}