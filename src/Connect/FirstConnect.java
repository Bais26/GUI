package Connect;

import Model.RespondModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getRespondFrontHttpUrl(myAddress);
//        System.out.println(response);


        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<RespondModel> RespondModel = new ArrayList<>();
        int count=  0;
        for (int i = 0; i < responseJSON.length(); i++) {

            RespondModel resmodel = new RespondModel();
//            System.out.println("ANJIM "+resmodel);
            JSONObject myJSONObject =responseJSON.getJSONObject(i);
//            System.out.println("ANJIM "+myJSONObject);

            String Harga = myJSONObject.getString("i_sell");
            resmodel.setI_sell(Harga);
            RespondModel.add(resmodel);

            int HargaInt= Integer.parseInt(Harga);
            if (HargaInt < 2000){
                count++;
            }
        }

        for(int index=0; index<RespondModel.size(); index++){
            int harga = Integer.parseInt(RespondModel.get(index).getI_sell());
            if(harga < 2000){
                System.out.println("Harga: " + harga);
            }
        }

        System.out.println("Semua harga obat 2000: " + count);
    }
}
