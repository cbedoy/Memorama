package uaa.memorama;

/**
 * Created by Bedoy on 3/12/16.
 */
public class Target
{
    private int mIdentifier;
    private boolean mDiscover;
    private boolean mSelected;

    public Target(int identifier){
        mIdentifier = identifier;
    }

    public void isPair(Target target){
        if (target.getIdentifier() == mIdentifier)
        {
            target.setDiscover(true);
            setDiscover(true);
        }
        else
        {
            target.setDiscover(false);
            setDiscover(false);

            setSelected(false);

            target.setSelected(false);
        }
    }

    public int getIdentifier() {
        return mIdentifier;
    }

    public boolean isDiscover() {
        return mDiscover;
    }

    public void setDiscover(boolean discover){
        mDiscover = discover;
    }

    public int getResource()
    {
        if (mSelected){
            return mIdentifier;
        }
        return mDiscover ? mIdentifier : R.drawable.card_bg;
    }

    public void setSelected(boolean selected){
        mSelected = selected;
    }

    public boolean isSelected() {
        return mSelected;
    }
}
