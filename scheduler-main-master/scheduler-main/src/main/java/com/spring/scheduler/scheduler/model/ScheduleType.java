package com.spring.scheduler.scheduler.model;

public enum ScheduleType {

	ROUNDROBIN, KNOCKOUT, DOUBLERR, GROUPSTAGEANDKNOCKOUT;

	// Round Robin Tournament:
	// In a round-robin tournament, each team plays against every other team in the
	// tournament.
	// It's a fair and comprehensive format that ensures each team faces all
	// opponents.
	// The team with the most points or wins at the end of the matches is declared
	// the winner.

	// Knockout Tournament (Single Elimination):
	// A knockout tournament features direct elimination matches.
	// Teams that lose are immediately eliminated, and the winners advance to the
	// next round.
	// The tournament continues until only one team remains, which becomes the
	// champion.

	// Double Round Robin Tournament:
	// Similar to the round-robin format, teams play against each other twice – once
	// at home and once away.
	// This format adds more matches and helps balance out home and away advantages.

	// Group Stage + Knockout Stage (Championship):
	// Commonly used in major international tournaments,
	// this format starts with a group stage where teams are divided into groups and
	// play round-robin matches.
	// The top teams from each group advance to the knockout stage, where they
	// compete in single-elimination matches until a champion is determined.

}
