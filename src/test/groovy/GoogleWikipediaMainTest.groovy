import geb.spock.GebSpec
import page.GoogleHomePage
import page.GoogleResultsPage
import page.WikipediaPage

class GoogleWikipediaMainTest extends GebSpec {

	def "first result for wikipedia search should be wikipedia"() {
		given:
		to GoogleHomePage

		expect:
		at GoogleHomePage

		when:
		search.field.value("wikipedia")

		then:
		waitFor { at GoogleResultsPage }

		and:
		firstResultLink.text() == "Wikipedia"

		when:
		firstResultLink.click()

		then:
		waitFor { at WikipediaPage }
	}
}