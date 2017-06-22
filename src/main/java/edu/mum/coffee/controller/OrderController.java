package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired
	PersonService personService;

	@GetMapping({ "/addOrder" })
	public String addOrder(Model model) {
		List<Person> personList = personService.findAll();
		model.addAttribute(personList);
		return "addOrder";
	}

	@GetMapping({ "/deleteOrder/{id}" })
	public String deleteOrder(@PathVariable int id, Model model) {
		orderService.delete(orderService.findById(id));
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "orderList";
	}

	// @GetMapping({"/deleteOrderLine/{orderLineId}/{orderId}"})
	// public String deleteOrderLine(@PathVariable Integer orderLineId,Integer
	// orderId, Model model) {
	// System.out.println("deleting orderline");
	// System.out.println("orderLine"+orderLineId);
	// System.out.println("order"+orderId);
	// List<Orderline> orderLines
	// =orderService.findById(orderId).getOrderLines();
	// for(Orderline orderline: orderLines){
	// if(orderline.getId()== orderLineId){
	// Orderline orderLine= orderline;
	// orderService.findById(orderId).removeOrderLine(orderLine);
	//
	// }
	// }
	//
	// List<Order> orderList = orderService.findAll();
	// model.addAttribute("orderList",orderList);
	// return "orderList";
	// }

	@GetMapping({ "/addOrderLine/{id}" })
	public String addOrderLine(@PathVariable int id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		System.out.println("add");
		System.out.println(username);
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		model.addAttribute("order", orderService.findById(id));
		return "addOrderLine";
	}

	@GetMapping({ "/createOrderLine/{id}" })
	public String createOrderLine(@PathVariable int id, @RequestParam("quantity") int quantity,
			@RequestParam("product") int productID, Model model) {
		System.out.println("creating orderLine");
		System.out.println("id:" + id);
		System.out.println("quantity:" + quantity);
		System.out.println("productId" + productID);
		Orderline orderLine = new Orderline();
		orderLine.setOrder(orderService.findById(id));
		orderLine.setProduct(productService.getProduct(productID));
		orderLine.setQuantity(quantity);
		orderService.findById(id).addOrderLine(orderLine);
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "orderList";
	}
	@RequestMapping(value = "/orderProductUser/{id}",method = RequestMethod.POST)
	public String orderProductUser(@PathVariable int id, @RequestParam("quantity") int quantity,
			@RequestParam("product") int productID, Model model) {
		Orderline orderLine = new Orderline();
		orderLine.setOrder(orderService.findById(id));
		orderLine.setProduct(productService.getProduct(productID));
		orderLine.setQuantity(quantity);
		orderService.findById(id).addOrderLine(orderLine);
		
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "userPage";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(@RequestParam("personId") Long personId, Model model) {
		System.out.println("creating order");
		System.out.println(personId);
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setPerson(personService.findById(personId));
		orderService.save(order);
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "orderList";
	}

	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public String addProductPage(Model model) {
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "orderList";
	}

	@RequestMapping(value = "/makeOrderPage", method = RequestMethod.GET)
	public String makeOrderPage(Model model) {
		Order order = new Order();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		System.out.println("hi");
		System.out.println(username);
		
		List<Order> orderList = orderService.findAll();
		boolean find = false;
		for(Order o: orderList){
			if(o.getPerson().getUser().getUsername().equals(username)){
				model.addAttribute("order", o);
				System.out.println("orderId"+o.getId());
				find = true;
			}
		}
		if(!find){
		List<Person> personList = personService.findAll();
		for(Person person : personList){
		if(person.getUser().getUsername().equals(username)){
			System.out.println();
			order.setOrderDate(new Date());
			order.setPerson(person);
			orderService.save(order);
		}
		}
		model.addAttribute("order", order);
		}
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		return "orderProduct";
	}

	@GetMapping({ "/createOrderLineCustomer" })
	public String createNewOrder(@RequestParam("quantity") int quantity, @RequestParam("product") int productID,
			Model model) {

		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "orderList";
	}
	// @Autowired
	// PersonService personService;
	//
	// @RequestMapping(value="/getOrderList", method = RequestMethod.GET)
	// public void getOrderList( Model model){
	// List<Order> orderList = orderService.findAll();
	// model.addAttribute(orderList);
	// }
	// @RequestMapping(value="/deleteOrder{id}", method = RequestMethod.GET)
	// public void deleteOrder(@PathVariable int id, Model model){
	// orderService.delete(orderService.findById(id));
	// }
	// @RequestMapping(value="/updateOrder{id}", method = RequestMethod.POST)
	// public void updateOrder(@RequestBody Date date, Person
	// person,@PathVariable int id){
	// Order o = orderService.findById(id);
	// o.setOrderDate(date);
	// o.setPerson(person);
	//
	// }
	// @RequestMapping(value="/createOrder", method = RequestMethod.POST)
	// public void createOrder(@RequestBody Order order){
	// orderService.save(order);
	//
	// }

}
