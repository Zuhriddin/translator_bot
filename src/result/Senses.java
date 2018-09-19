/**
 * 
 */
package result;

/**
 * @author Zuhriddin
 *
 */
public class Senses {
	private String id;

    private String[] domains;

    private String[] short_definitions;

    private String[] definitions;
    
    private Examples[] examples;

    private ThesaurusLinks[] thesaurusLinks;

    private Subsenses[] subsenses;

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

    
    public Examples[] getExamples() {
		return examples;
	}

	public void setExamples(Examples[] examples) {
		this.examples = examples;
	}

	public ThesaurusLinks[] getThesaurusLinks ()
    {
        return thesaurusLinks;
    }

    public void setThesaurusLinks (ThesaurusLinks[] thesaurusLinks)
    {
        this.thesaurusLinks = thesaurusLinks;
    }

    public Subsenses[] getSubsenses ()
    {
        return subsenses;
    }

    public void setSubsenses (Subsenses[] subsenses)
    {
        this.subsenses = subsenses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", domains = "+domains+", short_definitions = "+short_definitions+", definitions = "+definitions+", thesaurusLinks = "+thesaurusLinks+", subsenses = "+subsenses+"]";
    }

}
