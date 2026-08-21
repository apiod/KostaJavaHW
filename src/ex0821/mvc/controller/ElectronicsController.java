package ex0821.mvc.controller;

import java.io.IOException;
import java.util.List;

import ex0821.mvc.dto.Electronics;
import ex0821.mvc.exception.DuplicateModelNoException;
import ex0821.mvc.exception.ElectronicsArrayBoundsException;
import ex0821.mvc.exception.SearchNotFoundException;
import ex0821.mvc.service.ElectronicsService;
import ex0821.mvc.service.ElectronicsServiceImpl;
import ex0821.mvc.view.FailView;
import ex0821.mvc.view.SuccessView;



/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	 private ElectronicsService service;
    /**
     * 전체검색
     */
	 public ElectronicsController() {
		try {
			service = ElectronicsServiceImpl.getInstance();
		} catch (ClassNotFoundException | IOException e) {
			FailView.errorMessage("Controller"+e.getMessage());
		}
	}
    public void selectAll() {
		//서비스 호출하고 그결과에 따라 성공  or 실패로 이동
    	List<Electronics> list = service.selectAll();
    	SuccessView.printAll(list);
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
    	try {
    		service.insert(electronics);
		} catch (ElectronicsArrayBoundsException |DuplicateModelNoException e) {
			FailView.errorMessage(e.getMessage());
		}
    	SuccessView.printMessage("등록에 성공했습니다.");
    }
    
    

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
    	Electronics electronics = null;
    	try {
    		 electronics = service.searchByModelNo(modelNo);
    		 SuccessView.printSearchByModelNo(electronics);
	   }catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
    	try {
			service.update(electronics);
			SuccessView.printMessage(electronics+"수정했습니다.");
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param electronics
     */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
			SuccessView.printMessage("삭제되었습니다.");
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void selectSortByPrice() {
    	SuccessView.printAll(service.selectSortByPrice());
    }
    
    /**
     * 종료 전에 파일에 객체 저장
     */
    public void saveObject() {
		try {
			service.saveObject();
			SuccessView.printMessage("정상적으로 저장되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}











