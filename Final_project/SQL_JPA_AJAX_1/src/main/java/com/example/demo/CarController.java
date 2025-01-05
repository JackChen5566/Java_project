package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

	private final CarService carService;
	private final OrderService orderService;

	public CarController(CarService carService, OrderService orderService) {
		this.carService = carService;
		this.orderService = orderService;
	}

	@GetMapping
	public String listCars(Model model) {
		List<Car> cars = carService.getAllCars();
		model.addAttribute("cars", cars);
		return "car-list";
	}

	@GetMapping("/search")
	public String searchCars(@RequestParam String keyword, Model model) {
		List<Car> cars = carService.searchCars(keyword);
		model.addAttribute("cars", cars);
		System.out.println("查詢結果數量: " + cars.size());
		cars.forEach(car -> System.out.println("車型: " + car.getName()));
		return "car-list :: carList";
	}

	@GetMapping("/orderForm")
	public String showOrderForm(@RequestParam Long id, Model model) {
		Car car = carService.getCarById(id);
		model.addAttribute("car", car);
		return "order-form";
	}

	@PostMapping("/submitOrder")
	public String submitOrder(@RequestParam Long carId, 
			@RequestParam String carName, 
			@RequestParam String customerName,
			@RequestParam String phone) 
	{
		orderService.saveOrder(carId, carName, customerName, phone);
		System.out.println("carname: " + carName +" customername: "+ customerName +" phone: "+ phone);
		return "redirect:/cars";
	}

}
