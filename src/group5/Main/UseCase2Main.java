package group5.Main;

import group5.UI.FilterAndBrowseUI;
import group8.Dealer;

public class UseCase2Main {

	
	 public static void main(String[] args) throws Exception {
		 Dealer dealer = new Dealer();
		 dealer.setDealerID("1");
	        FilterAndBrowseUI FBui = new FilterAndBrowseUI(dealer);
	        FBui.buildUseCase2UI();
	    }

}
