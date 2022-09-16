package team2.returnbook;

import team2.join.JoinService;

public class ReturnBookController {
	
	private static ReturnBookController instance = new ReturnBookController();
    public static ReturnBookController getInstance() {
        return instance;
    }
    private ReturnBookController() {}
    
    private ReturnBookService service = ReturnBookService.getInstance();
    
    private  ReturnBookController (ReturnBookService service) {
    	this.service = service;
    }
    
    
}
