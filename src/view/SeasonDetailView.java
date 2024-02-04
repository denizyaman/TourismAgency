package src.view;

import src.business.PensionManager;
import src.business.SeasonManager;
import src.core.Helper;
import src.entity.Pension;
import src.entity.Seasons;

import javax.swing.*;

public class SeasonDetailView extends Layout {
    private JPanel container;
    private JLabel lbl_title;
    private JTextField fld_start_date;
    private JTextField fld_end_date;
    private JLabel lbl_end_date;
    private JLabel lbl_startDate;
    private JButton btn_save_season;
    private SeasonManager seasonManager;
    private Seasons seasons;
    private int selectedHotelId;

    public SeasonDetailView(Seasons seasons, int selectedHotelId) {

        this.seasonManager = new SeasonManager();

        this.add(container);
        this.GuiInitilaze(700,400);
        this.seasons = seasons;
        this.selectedHotelId=selectedHotelId;
        this.lbl_title.setText("Otel Id: "+String.valueOf(this.selectedHotelId));

        btn_save_season.addActionListener(e-> {

            boolean result;

            Seasons newSeason= new Seasons(this.selectedHotelId,fld_start_date.getText(),fld_end_date.getText());
            result=this.seasonManager.saveSeasons(newSeason);

            if(result){
                Helper.showMsg("done");
                dispose();
            }else{
                Helper.showMsg("error");
            }
        });
    }
}
