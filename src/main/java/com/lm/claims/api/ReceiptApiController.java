package com.lm.claims.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lm.claims.models.Receipt;
import com.lm.claims.repositories.ReceiptRepository;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptApiController {

	private ReceiptRepository receiptRepo;

	public ReceiptApiController(ReceiptRepository receiptRepo) {
		this.receiptRepo = receiptRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Receipt> getAll() {
		List<Receipt> receipts = receiptRepo.findAll();
		return receipts;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Receipt getOne(@PathVariable int id) {
		Receipt receipt = receiptRepo.findById(id);
		return receipt;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Receipt create(@RequestBody Receipt receipt) {
		return receiptRepo.save(receipt);
	}

}
