/**
 * 
 */
package result;

/**
 * @author Zuhriddin
 *
 */
public class Entries {
	private GrammaticalFeatures[] grammaticalFeatures;

    private String[] etymologies;

    private Senses[] senses;

    private String homographNumber;

    public GrammaticalFeatures[] getGrammaticalFeatures ()
    {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures (GrammaticalFeatures[] grammaticalFeatures)
    {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String[] getEtymologies ()
    {
        return etymologies;
    }

    public void setEtymologies (String[] etymologies)
    {
        this.etymologies = etymologies;
    }

    public Senses[] getSenses ()
    {
        return senses;
    }

    public void setSenses (Senses[] senses)
    {
        this.senses = senses;
    }

    public String getHomographNumber ()
    {
        return homographNumber;
    }

    public void setHomographNumber (String homographNumber)
    {
        this.homographNumber = homographNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [grammaticalFeatures = "+grammaticalFeatures+", etymologies = "+etymologies+", senses = "+senses+", homographNumber = "+homographNumber+"]";
    }

}
