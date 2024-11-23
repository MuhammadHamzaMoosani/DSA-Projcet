package Backend;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Helper
{

    public ArrayList<String> GetLocations(String Source,Driver driver)
    {
        ArrayList<String> list=new ArrayList();
        List<Vertex> list1=driver.getNeighbours(Source);
        for (int i = 0; i <list1.size() ; i++)
        {
            list.add(list1.get(i).label);
        }

        return list;

    }
}
