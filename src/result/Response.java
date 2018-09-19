/**
 * 
 */
package result;

/**
 * @author Zuhriddin
 *
 */
public class Response {
	private Results[] results;

    private Metadata metadata;

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", metadata = "+metadata+"]";
    }
}
