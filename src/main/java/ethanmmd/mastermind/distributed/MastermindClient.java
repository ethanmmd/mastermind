package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.Mastermind;
import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.distributed.proxy.LogicProxy;
import ethanmmd.mastermind.views.View;
import ethanmmd.mastermind.views.console.ConsoleView;

public class MastermindClient extends Mastermind {

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    @Override
    protected Logic createLogic() {
        return new LogicProxy();
    }


    public static void main(String[] args) {
        new MastermindClient().play();
    }
}
