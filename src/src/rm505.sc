;;; Sierra Script 1.0 - (do not remove this comment)
(script# 505)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use Sq4Feature)
(use Cycle)
(use Obj)

(public
	rm505 0
)

(instance rm505 of SQRoom
	(properties
		picture 505
		style $000a
		north 150
		east 510
		south 520
		west 500
		vanishingY -250
	)
	
	(method (init)
		(switch global12
			(north
				(self setScript: enterScript 0 0)
			)
			(south
				(self setScript: enterScript 0 (brain level?))
			)
			(else  (proc0_3))
		)
		(gEgo init:)
		(self setRegions: 704)
		(super init:)
		(switch (brain level?)
			(2
				(brain makePolygon: 65 189 74 166 236 166 248 189)
				(brain makePolygon: 281 189 281 166 319 166 319 189)
				(brain makePolygon: 0 189 0 0 319 0 319 149 49 149 27 189)
			)
			(3
				(brain makePolygon: 0 108 0 0 80 0 33 108)
				(brain makePolygon: 231 0 319 0 319 108 277 108)
				(brain
					makePolygon: 0 125 56 125 96 0 219 0 262 125 319 125 319 189 0 189
				)
			)
		)
		((ScriptID 704 4)
			x: 83
			y: 135
			nsLeft: 76
			nsTop: 130
			nsBottom: 140
			nsRight: 90
			sightAngle: 90
			init:
		)
		(roomFeature init:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gEgo 8)
				(cond 
					((> (gEgo y?) 100) (brain level: 1 exitDir: 180))
					((> (gEgo x?) 160) (brain exitDir: 315))
					(else (brain exitDir: 45))
				)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch register
					(0
						(if (< (gEgo x?) 275)
							(= temp2 64)
							(= temp3 25)
							(= temp4 64)
							(= temp5 50)
						else
							(= temp2 224)
							(= temp3 -1)
							(= temp4 243)
							(= temp5 50)
						)
					)
					(2
						(if (< (gEgo x?) 120)
							(= temp2 51)
							(= temp3 230)
							(= temp4 67)
							(= temp5 162)
						else
							(= temp2 275)
							(= temp3 230)
							(= temp4 259)
							(= temp5 162)
						)
					)
				)
				(gEgo
					x: temp2
					y: temp3
					setMotion: MoveTo temp4 temp5 self
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance roomFeature of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 500 say: 2)
			)
			(2
				(gSq4GlobalNarrator modNum: 500 say: 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
