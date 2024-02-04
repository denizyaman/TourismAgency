package src.view;

import src.business.PensionManager;
import src.core.Helper;
import src.entity.Pension;
import src.entity.User;

import javax.swing.*;

public class PensionDetailView extends Layout{
    private JPanel container;
    private JComboBox combo_pension;
    private JLabel lbl_pensionCombo;
    private JPanel pnl_container;
    private JLabel lbl_title;
    private JButton btn_save_pension;
    private PensionManager pensionManager;
    private Pension pension;
    private int selectedHotelId;
    public PensionDetailView(Pension pension,int selectedHotelId) { // guncellemek ıcın

        this.pensionManager = new PensionManager();

        this.add(container);
        this.GuiInitilaze(700,400);
        this.pension = pension;
        this.selectedHotelId=selectedHotelId;
        this.lbl_title.setText("Otel Id: "+String.valueOf(this.selectedHotelId));

        btn_save_pension.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz

            boolean result;

            Pension newPension= new Pension(this.selectedHotelId,String.valueOf(combo_pension.getSelectedItem())); // yenı pansiyon olusturuyoruz
            result=this.pensionManager.savePension(newPension); // managerda kı methoda parametre olarak verıyoruz

            if(result){// basarıyla kaydedıldıyse basarılı dıyıp kapatıyoruz
                Helper.showMsg("done");
                dispose();
            }else{
                Helper.showMsg("error");
            }
        });
    }
}
