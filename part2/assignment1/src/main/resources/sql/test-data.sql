INSERT INTO CATEGORY (ID, NAME) VALUES (1, 'Novels');
INSERT INTO CATEGORY (ID, NAME) VALUES (2, 'Java');
INSERT INTO CATEGORY (ID, NAME) VALUES (3, 'Programming');
INSERT INTO CATEGORY (ID, NAME) VALUES (4, 'Poetry');

INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (1, "978-0075536321", "Anna Karenina", 17.57);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (1, "978-0060194994", "To Kill A Mockingbird", 25.95);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (2, "978-0137150021", "Effective Java", 43.86);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (3, "978-0132350884", "Clean Code", 25.33);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (4, "978-0571096343", "The Waste Land by T.S. Eliot", 99.99);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (4, "978-0375505966", "Still I Rise by Maya Angelou", 30.29);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (4, "978-0156332255", "Four Quartets", 8.99);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (4, "978-1400079988", "War and Peace", 21.00);
INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (3, "978-0128006450", "Physically Based Rendering", 109.95);

INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Leo", "Tolstoy", "Count Lev Nikolayevich Tolstoy is regarded as one of the greatest authors of all time. He received nominations for the Nobel Prize in Literature every year from 1902 to 1906 and for the Nobel Peace Prize in 1901, 1902, and 1909.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Harper", "Lee", "Nelle Harper Lee was an American novelist best known for her 1960 novel To Kill a Mockingbird. It won the 1961 Pulitzer Prize and has become a classic of modern American literature.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Thomas", "Eliot", "Thomas Stearns Eliot OM was a poet, essayist, publisher, playwright, literary critic and editor. Considered one of the 20th century's major poets, he is a central figure in English-language Modernist poetry.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Maya", "Angelou", "Maya Angelou was an American poet, memoirist, and civil rights activist.  She received dozens of awards and more than 50 honorary degrees.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Parr", "Matt", "Matt Pharr is a Software Engineer at Google, received his PhD from the Stanford Graphics Lab, and received an Academy Award for Physically Based Rendering.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Jakob", "Wenzel", "Wenzel Jakob is an assistant professor at École polytechnique fédérale de Lausanne (EPFL).  He received an Academy Award for Physically Based Rendering.");
INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Humphreys", "Greg", "Greg Humphreys is a Software Lead at NVIDIA, received his PhD from the Stanford Graphics Lab, & received an Academy Award for Physically Based Rendering.");

INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES (1, 1), (2, 2), (3, 5), (4, 6), (3, 7), (1, 8), (5, 9), (6, 9), (7, 9);

-- Test data added by the app demo
-- INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) VALUES (3, "978-0367505035", "Fundamentals of Computer Graphics", 126.0);
-- INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ("Shirley", "Peter", "Peter Shirley is computer graphics researcher, NVIDIA computer scientist, and University of Utah adjunct professor.");
-- INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES (8, 10);
