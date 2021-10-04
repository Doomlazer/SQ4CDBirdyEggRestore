;;; Sierra Script 1.0 - (do not remove this comment)
(script# 375)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use MoveFwd)
(use Cycle)
(use Obj)

(public
	rm375 0
)

(local
	[local0 10] = [0 0 206 0 183 28 85 76 0 82]
	local10 =  65
	local11 =  -1
)
(instance rm375 of SQRoom
	(properties
		picture 375
		style $000a
		east 380
		south 370
		west 370
	)
	
	(method (init &tmp temp0 temp1)
		(proc0_2)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 49)
					(= temp1 237)
				else
					(= temp0 -16)
					(= temp1 181)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 333)
					(= temp1 78)
				else
					(= temp0 327)
					(= temp1 -8)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
			(else 
				(gLongSong number: 405 loop: -1 flags: 1 play: 95)
				(self setScript: fromStoreScript 0 (> (gEgo x?) 160))
			)
		)
		(light1 init: setCycle: Fwd)
		(light2 init: setCycle: Fwd)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 149 0 63 51 114 47 125 44 128
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 298 0 224 39 216 39 208 38 106 0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 123 28 150 74 118 91 84 49
					yourself:
				)
		)
		(signPoly points: @local0 size: 5)
		(gEgo
			setPri: -1
			code: beltwayCode
			init:
			setCycle: SyncWalk
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 319 121 319 189 185 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 21 319 66 215 117 174 95
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 185 132 116 170 140 72 189
					yourself:
				)
		)
		(self setRegions: 700)
		(store init:)
		(bush1 init:)
		(bush2 init:)
		(cond 
			((and (!= global12 376) (not (proc0_6 9))) (gLongSong2 number: 19 loop: -1 flags: 1 play: 65))
			((proc0_6 9) (gLongSong2 number: 0 vol: 0 stop:))
		)
	)
	
	(method (doit &tmp temp0)
		(if (not (-- local11))
			(cond 
				(
					(<
						(= temp0 (GetDistance (gEgo x?) (gEgo y?) local10 0))
						0
					)
					(= temp0 0)
				)
				((> temp0 300) (= temp0 300))
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local11 60)
		)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 2)
				(proc0_2)
				((ScriptID 700 0) enterBelt: egoBwGreen)
				(self setScript: (ScriptID 700 2) 0 east)
			)
			(
			(or (== (gEgo edgeHit?) 4) (== (gEgo edgeHit?) 3))
				(if (proc0_5 gEgo 4)
					(gEgo
						edgeHit: 0
						setMotion: 0
						posn: (+ (gEgo x?) 3) (- (gEgo y?) 4)
					)
				else
					(proc0_2)
					((ScriptID 700 0) enterBelt: egoBwBlue)
					(self setScript: (ScriptID 700 2) 0 west)
				)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromStoreScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: (if register 149 else 70)
					y: (if register 43 else 82)
					setHeading: 135
					setMotion: MoveFwd 20 self
				)
			)
			(1
				(proc700_5 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance beltwayCode of Code
	(properties)
	
	(method (doit)
		(cond 
			((global2 script?) 0)
			((proc0_5 gEgo 8) (global2 newRoom: 376))
			((proc0_5 gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1)
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((proc0_5 gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2)
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon?) (egoBwBlue onCon?))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2)
				(proc700_5 1)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 3
		yOff 1
		xTweak 1
		yTweak 1
		key 225
		head 63
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 1
		yOff 1
		xTweak 1
		yTweak 1
		key 45
		head 242
		xDir -1
		yDir 1
	)
)

(instance door of Sq4View
	(properties
		x 21
		y 82
		sightAngle 90
		view 375
		loop 2
		priority 1
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(4 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light1 of Sq4Prop
	(properties
		x 30
		y 110
		view 375
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signPoly of Polygon
	(properties)
)

(instance light2 of Sq4Prop
	(properties
		x 214
		y 20
		view 375
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance store of Sq4Feature
	(properties
		x 20
		y 20
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(<=
				49
				(/
					(* 100 (- 145 (param1 y?)))
					(proc999_3 1 (param1 x?))
				)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 68
		y 145
		nsTop 129
		nsLeft 62
		nsBottom 153
		nsRight 84
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 370 say: 12)
			)
			(6 (gSq4GlobalNarrator say: 7))
			(7 (gSq4GlobalNarrator say: 8))
			(4 (gSq4GlobalNarrator say: 9))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 260
		y 45
		nsTop 31
		nsLeft 254
		nsBottom 57
		nsRight 276
	)
	
	(method (doVerb theVerb)
		(bush1 doVerb: theVerb)
	)
)
