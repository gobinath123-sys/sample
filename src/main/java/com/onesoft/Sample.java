package com.onesoft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class Sample {

	@GetMapping(value = "/hi")
	public String display() {
		return "gobi";
	}
	@GetMapping(value="/handle")
	 ResponseEntity<Integer> handle() {
		 return new ResponseEntity<Integer>(1144+11, HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping(value = "/myname")
	public String myname() {
		return "gobi";
	}

	@GetMapping(value = "/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	@GetMapping(value = "/factorial/{a}")
	public int factorial(@PathVariable int a) {
		int val = 1;
		for (int i = 1; i <= a; i++) {
			val = val * i;
		}
		return val;
	}

	@GetMapping(value = "/odd/{a}")
	public int odd(@PathVariable int a) {
		if (a % 2 == 1) {
			return a * a;
		} else {
			return a * a * a;
		}

	}

	@GetMapping(value = "/nonvowels/{a}")
	public int nonvowels(@PathVariable String a) {
		int count = 0;
		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o'
					&& a.charAt(i) != 'u') {
				count = count + 1;
			}
		}
		return count;
	}

	@GetMapping(value = "/squar/{num}")
	public List<Integer> squar(@PathVariable int num) {
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			li.add(i * i);
		}
		return li;
	}

	@GetMapping(value = "/getserius/{num}")
	public List<Integer> getserius(@PathVariable int num) {
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			li.add(i);
		}
		return li;
	}

	@GetMapping(value = "/fibanacci/{num}")
	public List<Integer> fibanacci(@PathVariable int num) {
		List<Integer> li = new ArrayList<>();
		int num1 = 0;
		int num2 = 1;
		for (int i = 1; i <= num; i++) {
			int sum = num1 + num2;
			num1 = num2;
			num2 = sum;
			li.add(num2);
		}
		return li;
	}

	@GetMapping(value = "/palindrom/{num}")
	public List<Integer> palindrom(@PathVariable int num) {
		List<Integer> li = new ArrayList<>();
		int num1 = 0, rem;
		for (int i = 0; num1 > 0; num1 /= 10) {
			rem = num1 % 10;
			i = (i * 10) + rem;
		}
		int i = 0;
		if (i == num1) {
			System.out.println(num1 + "palintrom");
		} else {
			System.out.println(num1 + "not palintrom");
		}
		return li;
	}

	@GetMapping(value = "/setcar")
	public Car setCar(@RequestBody Car c) {
		return c;
	}

	@GetMapping("setAllcar")
	public List<Car> setall(@RequestBody List<Car> c) {
		return c;
	}

	@GetMapping(value = "/maxPrice")
	public int maxPrice(@RequestBody List<Car> c) {
		Car price = c.get(0);
		for (Car x : c) {
			if (x.getPrice() > price.getPrice()) {
				price = x;
			}
		}
		return price.getPrice();

	}

	@GetMapping(value = "/minPrice")
	public int minPrice(@RequestBody List<Car> c) {
		Car price = c.get(0);
		for (Car x : c) {
			if (x.getPrice() < price.getPrice()) {
				price = x;
			}
		}
		return price.getPrice();
	}

	@GetMapping(value = "/color/{a}")
	public List<Car> color(@RequestBody List<Car> cars, @PathVariable String a) {
		List<Car> tem = new ArrayList<>();
		for (Car x : cars) {
			if (x.getColor().equals(a)) {
				tem.add(x);
			}
		}
		return tem;
	}

	@GetMapping(value = "/price/{a}")
	public List<Car> price(@RequestBody List<Car> cars, @PathVariable int a) {
		List<Car> temp = new ArrayList<>();
		for (Car x : cars) {
			if (x.getPrice() > a) {
				temp.add(x);

			}
		}
		return temp;
	}

	@GetMapping(value = "/gender/{a}")
	public List<Employee> gender(@RequestBody List<Employee> emp, @PathVariable String a) {
		List<Employee> tem = new ArrayList<>();
		for (Employee x : emp) {
			if (x.getGender().equals(a)) {
				tem.add(x);
			}
		}
		return tem;

	}

	@GetMapping(value = "/maxsalary")
	public Employee maxsalary(@RequestBody List<Employee> emp) {
		List<Employee> tem = new ArrayList<>();
		Employee salary = emp.get(0);
		for (Employee x : emp) {
			if (x.getSalary() > salary.getSalary()) {
				salary = x;
				tem.add(salary);
			}
		}
		return salary;

	}

	@RequestMapping("/admin")
	public int minsalary(@RequestBody List<Employee> emp) {
		Employee salary = emp.get(0);
		for (Employee x : emp) {
			if (x.getSalary() < salary.getSalary()) {
				salary = x;
			}
		}
		return salary.getSalary();
	}

	@GetMapping(value = "/salaryinc")
	public List<Employee> salaryinc(@RequestBody List<Employee> emp) {
		for (Employee x : emp) {
			if (x.getSalary() <= 35000 && x.getSalary() >= 25000) {
				x.setSalary(x.getSalary() + x.getSalary() * 20 / 100);
			} else if (x.getSalary() >= 35000 && x.getSalary() <= 55000) {
				x.setSalary(x.getSalary() + x.getSalary() * 15 / 100);
			} else if (x.getSalary() <= 75000 && x.getSalary() >= 55000) {
				x.setSalary(x.getSalary() + x.getSalary() * 10 / 100);
			}
		}
		return emp;

	}
}
