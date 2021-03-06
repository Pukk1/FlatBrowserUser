package User;

public class CreateConnection extends Thread{

    TransferCenter transferCenter;
    Boolean connectionReCreated = false;

    public CreateConnection(TransferCenter transferCenter){
        this.transferCenter = transferCenter;
    }

    @Override
    public void run(){
        transferCenter = new TransferCenter(transferCenter);
        connectionReCreated = true;
    }
}
