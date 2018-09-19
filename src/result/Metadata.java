/**
 * 
 */
package result;

/**
 * @author Zuhriddin
 *
 */
public class Metadata {
	private String provider;

    public String getProvider ()
    {
        return provider;
    }

    public void setProvider (String provider)
    {
        this.provider = provider;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [provider = "+provider+"]";
    }

}
