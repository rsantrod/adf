import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class TestBean {
    public TestBean() {
    }

    public void popupFetchListener(PopupFetchEvent popupFetchEvent) {
        if(popupFetchEvent.getLaunchSourceClientId().equals("bCreate")){
            BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            OperationBinding method = bindings.getOperationBinding("CreateInsert");  
            method.execute();
        }
    }
}
