package com.product.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.Entity.Branch;
import com.product.Repository.BranchRepository;


@RestController
@RequestMapping("/api/")
public class BranchController {
	private final BranchRepository branchres;
	BranchController(BranchRepository branchres){
		this.branchres = branchres;
	}
	
	@GetMapping("/branch/")
	List<Branch> all(){
		return branchres.findAll();
	}
	
	@PostMapping("/branch/")
	Branch newBranch(@RequestBody Branch newBranch) {
		return branchres.save(newBranch);
	}
	
	@GetMapping("/branch/{id}")
	Branch one(@PathVariable Long id) {
		return branchres.findById(id)
				.orElseThrow(() -> new BranchNotFoundException(id));
	}
	
	@PutMapping("/branch/{id}")
	Branch replaceBranch(@RequestBody Branch newBranch, @PathVariable Long id) {
		return branchres.findById(id)
				.map(branch ->{
					branch.setName(newBranch.getName());
					return branchres.save(branch);
				})
				.orElseGet(() ->{
					newBranch.setId(id);
					return branchres.save(newBranch);
				
				});
	}
	@DeleteMapping("/branch/{id}")
		void deleteBranch(@PathVariable Long id) {
			branchres.deleteById(id);
		}
	
	
}
