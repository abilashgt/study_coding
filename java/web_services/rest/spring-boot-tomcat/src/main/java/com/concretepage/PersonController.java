package com.concretepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concretepage.component.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@RequestMapping("/details")
	public Person getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}
}