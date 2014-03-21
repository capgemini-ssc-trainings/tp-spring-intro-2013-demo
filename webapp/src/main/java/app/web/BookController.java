package app.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;
import app.shared.service.IBookService;

//[ Aufgabe 7.6
@SessionAttributes("bookSearchCriteria")
//] Aufgabe 7.6 Put the bookSearchCriteria in the HTTP Session
//[ Aufgabe 7.5
@Controller
//] Aufgabe 7.5 Mark this class as a controller
public class BookController {
	private IBookService bookService;

	@Autowired
	public void setBookSearchService(IBookService bookSearchService) {
		this.bookService = bookSearchService;
	}

	@RequestMapping(value = { "/", " * ", "/newBookSearch" }, method = RequestMethod.GET)
	public String newSearch(Model model) {
		//[ Aufgabe 7.7
		// Note: putting BookSearchCriteria into the model causes it to be
		// stored in the HTTP session because of @SessionAttributes annotation
		model.addAttribute("bookSearchCriteria", new BookSearchCriteria());
		//] Aufgabe 7.7 Put new fresh BookSearchCriteria instance into the model
		return "redirect:/bookSearch";
	}

	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String displaySearchCriteria() {
		return "bookSearch";
	}

	//[ Aufgabe 7.8
	@RequestMapping(value = "/bookSearch", method = RequestMethod.POST)
	//] Aufgabe 7.8 Map POST /bookSearch requests to this method  
	//[ Aufgabe 7.9
	public String processSearchForm(@Valid BookSearchCriteria bookSearchCriteria, BindingResult bindingResult) {
	//] Aufgabe 7.9 Enable validation of the BookSearchCriteria - public String processSearchForm(BookSearchCriteria bookSearchCriteria, BindingResult bindingResult) {;
		//[ Aufgabe 7.10
		if (bindingResult.hasErrors()) {
			return "bookSearch";
		} else {
			return "redirect:/bookOverview";
		}
		//] Aufgabe 7.10 If any errors occurred, display them, otherwise go to /bookOverview (via redirect) - return null;
	}

	@RequestMapping(value = "/bookOverview", method = RequestMethod.GET)
	public ModelAndView displaySearchResults(BookSearchCriteria bookSearchCriteria) {
		List<Book> results = bookService
				.findBySearchCriteria(bookSearchCriteria);
		return new ModelAndView("bookOverview", "bookList", results);
	}
	
	@RequestMapping(value = "/bookView", method = RequestMethod.GET)
	//[ Aufgabe 7.11
	public ModelAndView displayBook(@RequestParam("id") Long id) {
	//] Aufgabe 7.11 Make the id parameter (passed as HTTP request GET parameter) to be bound the the id method parameter - public ModelAndView displayBook(Long id) {;
		Book book = bookService.findById(id);
		return new ModelAndView("bookView", "book", book);
	}
}
