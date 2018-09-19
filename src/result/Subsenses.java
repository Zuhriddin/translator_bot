/**
 * 
 */
package result;

/**
 * @author Zuhriddin
 *
 */
public class Subsenses {

	private String id;

    private String[] domains;

    private VariantForms[] variantForms;

    private String[] short_definitions;

    private String[] definitions;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getDomains ()
    {
        return domains;
    }

    public void setDomains (String[] domains)
    {
        this.domains = domains;
    }

    public VariantForms[] getVariantForms ()
    {
        return variantForms;
    }

    public void setVariantForms (VariantForms[] variantForms)
    {
        this.variantForms = variantForms;
    }

    public String[] getShort_definitions ()
    {
        return short_definitions;
    }

    public void setShort_definitions (String[] short_definitions)
    {
        this.short_definitions = short_definitions;
    }

    public String[] getDefinitions ()
    {
        return definitions;
    }

    public void setDefinitions (String[] definitions)
    {
        this.definitions = definitions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", domains = "+domains+", variantForms = "+variantForms+", short_definitions = "+short_definitions+", definitions = "+definitions+"]";
    }
}
