DELETE FROM advisedby WHERE s_id = 18;
DELETE FROM advisedby WHERE s_id = 37;
select * from professorCount
/*Είναι updatable διότι διαγράφοντας τους φοιτητές με s_id 18 & s_id 37 μειώνονται οι μετρητές των αντίστοιχων καθηγητών συμβούλων p_id 335 & 79 αντίστοιχα.*/
