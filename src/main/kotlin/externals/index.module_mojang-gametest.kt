@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import kotlin.js.Promise

external enum class FluidType {
    water /* = 0 */,
    lava /* = 1 */,
    powderSnow /* = 2 */,
    potion /* = 3 */
}

external open class FenceConnectivity {
    open var east: Boolean
    open var north: Boolean
    open var south: Boolean
    open var west: Boolean
}

external open class GameTestSequence {
    open fun thenExecute(callback: () -> Unit): GameTestSequence
    open fun thenExecuteAfter(delayTicks: Number, callback: () -> Unit): GameTestSequence
    open fun thenExecuteFor(tickCount: Number, callback: () -> Unit): GameTestSequence
    open fun thenFail(errorMessage: String)
    open fun thenIdle(delayTicks: Number): GameTestSequence
    open fun thenSucceed()
    open fun thenWait(callback: () -> Unit): GameTestSequence
    open fun thenWaitAfter(delayTicks: Number, callback: () -> Unit): GameTestSequence
}

external open class RegistrationBuilder {
    open fun batch(batchName: String /* "night" | "day" */): RegistrationBuilder
    open fun maxAttempts(attemptCount: Number): RegistrationBuilder
    open fun maxTicks(tickCount: Number): RegistrationBuilder
    open fun padding(paddingBlocks: Number): RegistrationBuilder
    open fun required(isRequired: Boolean): RegistrationBuilder
    open fun requiredSuccessfulAttempts(attemptCount: Number): RegistrationBuilder
    open fun rotateTest(rotate: Boolean): RegistrationBuilder
    open fun setupTicks(tickCount: Number): RegistrationBuilder
    open fun structureName(structureName: String): RegistrationBuilder
    open fun tag(tag: String): RegistrationBuilder
}

external open class SculkSpreader {
    open var maxCharge: Number
    open fun addCursorsWithOffset(offset: BlockLocation, charge: Number)
    open fun getCursorPosition(index: Number): BlockLocation
    open fun getNumberOfCursors(): Number
    open fun getTotalCharge(): Number
}

external open class SimulatedPlayer : Player {
    override var dimension: Dimension
    override var headLocation: Location
    open var headRotation: XYRotation
    override var id: String
    override var isSneaking: Boolean
    override var location: Location
    override var name: String
    override var nameTag: String
    override var onScreenDisplay: ScreenDisplay
    override var rotation: XYRotation
    override var scoreboard: ScoreboardIdentity
    override var selectedSlot: Number
    override var target: Entity
    override var velocity: Vector
    override var viewVector: Vector
    override fun addEffect(effectType: EffectType, duration: Number, amplifier: Number, showParticles: Boolean)
    open fun addExperience(amount: Number): Boolean
    override fun addTag(tag: String): Boolean
    open fun attack(): Boolean
    open fun attackEntity(entity: Entity): Boolean
    open fun breakBlock(blockLocation: BlockLocation, direction: Number = definedExternally): Boolean
    override fun getBlockFromViewVector(options: BlockRaycastOptions): Block
    override fun getComponent(componentId: String): IEntityComponent
    override fun getComponents(): Array<IEntityComponent>
    override fun getDynamicProperty(identifier: String): dynamic /* Boolean | Number | String */
    override fun getEffect(effectType: EffectType): Effect
    override fun getEntitiesFromViewVector(options: EntityRaycastOptions): Array<Entity>
    override fun getItemCooldown(itemCategory: String): Number
    override fun getTags(): Array<String>
    open fun giveItem(itemStack: ItemStack, selectSlot: Boolean = definedExternally): Boolean
    override fun hasComponent(componentId: String): Boolean
    override fun hasTag(tag: String): Boolean
    open fun interact(): Boolean
    open fun interactWithBlock(blockLocation: BlockLocation, direction: Number = definedExternally): Boolean
    open fun interactWithEntity(entity: Entity): Boolean
    open fun jump(): Boolean
    override fun kill()
    open fun lookAtBlock(blockLocation: BlockLocation)
    open fun lookAtEntity(entity: Entity)
    open fun lookAtLocation(location: Location)
    open fun move(westEast: Number, northSouth: Number, speed: Number = definedExternally)
    open fun moveRelative(leftRight: Number, backwardForward: Number, speed: Number = definedExternally)
    open fun moveToBlock(blockLocation: BlockLocation, speed: Number = definedExternally)
    open fun moveToLocation(location: Location, speed: Number = definedExternally)
    open fun navigateToBlock(blockLocation: BlockLocation, speed: Number = definedExternally): NavigationResult
    open fun navigateToEntity(entity: Entity, speed: Number = definedExternally): NavigationResult
    open fun navigateToLocation(location: Location, speed: Number = definedExternally): NavigationResult
    open fun navigateToLocations(locations: Array<Location>, speed: Number = definedExternally)
    override fun playSound(soundID: String, soundOptions: SoundOptions)
    override fun removeDynamicProperty(identifier: String): Boolean
    override fun removeTag(tag: String): Boolean
    open fun rotateBody(angleInDegrees: Number)
    override fun runCommand(commandString: String): Any
    override fun runCommandAsync(commandString: String): Promise<CommandResult>
    open fun setBodyRotation(angleInDegrees: Number)
    override fun setDynamicProperty(identifier: String, value: Boolean)
    override fun setDynamicProperty(identifier: String, value: Number)
    override fun setDynamicProperty(identifier: String, value: String)
    open fun setGameMode(gameMode: GameMode)
    open fun setItem(itemStack: ItemStack, slot: Number, selectSlot: Boolean = definedExternally): Boolean
    override fun setRotation(degreesX: Number, degreesY: Number)
    override fun setVelocity(velocity: Vector)
    override fun startItemCooldown(itemCategory: String, tickDuration: Number)
    open fun stopBreakingBlock()
    open fun stopInteracting()
    open fun stopMoving()
    open fun stopUsingItem()
    open fun teleport(location: Location, dimension: Dimension, xRotation: Number, yRotation: Number)
    open fun teleportFacing(location: Location, dimension: Dimension, facingLocation: Location)
    override fun triggerEvent(eventName: String)
    open fun useItem(itemStack: ItemStack): Boolean
    open fun useItemInSlot(slot: Number): Boolean
    open fun useItemInSlotOnBlock(slot: Number, blockLocation: BlockLocation, direction: Number = definedExternally, faceLocationX: Number = definedExternally, faceLocationY: Number = definedExternally): Boolean
    open fun useItemOnBlock(itemStack: ItemStack, blockLocation: BlockLocation, direction: Number = definedExternally, faceLocationX: Number = definedExternally, faceLocationY: Number = definedExternally): Boolean
}

external open class Tags {
    companion object {
        var suiteAll: String = definedExternally
        var suiteDebug: String = definedExternally
        var suiteDefault: String = definedExternally
        var suiteDisabled: String = definedExternally
    }
}

external open class Test {
    open fun assert(condition: Boolean, message: String)
    open fun assertBlockPresent(blockType: BlockType, blockLocation: BlockLocation, isPresent: Boolean = definedExternally)
    open fun assertBlockState(blockLocation: BlockLocation, callback: (arg: Block) -> Boolean)
    open fun assertCanReachLocation(mob: Entity, blockLocation: BlockLocation, canReach: Boolean = definedExternally)
    open fun assertContainerContains(itemStack: ItemStack, blockLocation: BlockLocation)
    open fun assertContainerEmpty(blockLocation: BlockLocation)
    open fun assertEntityHasArmor(entityTypeIdentifier: String, armorSlot: Number, armorName: String, armorData: Number, blockLocation: BlockLocation, hasArmor: Boolean = definedExternally)
    open fun assertEntityHasComponent(entityTypeIdentifier: String, componentIdentifier: String, blockLocation: BlockLocation, hasComponent: Boolean = definedExternally)
    open fun assertEntityInstancePresent(entity: Entity, blockLocation: BlockLocation, isPresent: Boolean = definedExternally)
    open fun assertEntityPresent(entityTypeIdentifier: String, blockLocation: BlockLocation, isPresent: Boolean = definedExternally)
    open fun assertEntityPresentInArea(entityTypeIdentifier: String, isPresent: Boolean = definedExternally)
    open fun assertEntityState(blockLocation: BlockLocation, entityTypeIdentifier: String, callback: (arg: Entity) -> Boolean)
    open fun assertEntityTouching(entityTypeIdentifier: String, location: Location, isTouching: Boolean = definedExternally)
    open fun assertIsWaterlogged(blockLocation: BlockLocation, isWaterlogged: Boolean = definedExternally)
    open fun assertItemEntityCountIs(itemType: ItemType, blockLocation: BlockLocation, searchDistance: Number, count: Number)
    open fun assertItemEntityPresent(itemType: ItemType, blockLocation: BlockLocation, searchDistance: Number, isPresent: Boolean = definedExternally)
    open fun assertRedstonePower(blockLocation: BlockLocation, power: Number)
    open fun destroyBlock(blockLocation: BlockLocation, dropResources: Boolean = definedExternally)
    open fun fail(errorMessage: String)
    open fun failIf(callback: () -> Unit)
    open fun getBlock(blockLocation: BlockLocation): Block
    open fun getDimension(): Dimension
    open fun getFenceConnectivity(blockLocation: BlockLocation): FenceConnectivity
    open fun getSculkSpreader(blockLocation: BlockLocation): SculkSpreader
    open fun getTestDirection(): Direction
    open fun idle(tickDelay: Number): Promise<Unit>
    open fun killAllEntities()
    open fun pressButton(blockLocation: BlockLocation)
    open fun print(text: String)
    open fun pullLever(blockLocation: BlockLocation)
    open fun pulseRedstone(blockLocation: BlockLocation, duration: Number)
    open fun relativeBlockLocation(worldBlockLocation: BlockLocation): BlockLocation
    open fun relativeLocation(worldLocation: Location): Location
    open fun removeSimulatedPlayer(simulatedPlayer: SimulatedPlayer)
    open fun rotateDirection(direction: Direction): Direction
    open fun rotateVector(vector: Vector): Vector
    open fun runAfterDelay(delayTicks: Number, callback: () -> Unit)
    open fun runAtTickTime(tick: Number, callback: () -> Unit)
    open fun setBlockPermutation(blockData: BlockPermutation, blockLocation: BlockLocation)
    open fun setBlockType(blockType: BlockType, blockLocation: BlockLocation)
    open fun setFluidContainer(location: BlockLocation, type: Number)
    open fun setTntFuse(entity: Entity, fuseLength: Number)
    open fun spawn(entityTypeIdentifier: String, blockLocation: BlockLocation): Entity
    open fun spawnAtLocation(entityTypeIdentifier: String, location: Location): Entity
    open fun spawnItem(itemStack: ItemStack, location: Location): Entity
    open fun spawnSimulatedPlayer(blockLocation: BlockLocation, name: String = definedExternally, gameMode: GameMode = definedExternally): SimulatedPlayer
    open fun spawnWithoutBehaviors(entityTypeIdentifier: String, blockLocation: BlockLocation): Entity
    open fun spawnWithoutBehaviorsAtLocation(entityTypeIdentifier: String, location: Location): Entity
    open fun spreadFromFaceTowardDirection(blockLocation: BlockLocation, fromFace: Direction, direction: Direction)
    open fun startSequence(): GameTestSequence
    open fun succeed()
    open fun succeedIf(callback: () -> Unit)
    open fun succeedOnTick(tick: Number)
    open fun succeedOnTickWhen(tick: Number, callback: () -> Unit)
    open fun succeedWhen(callback: () -> Unit)
    open fun succeedWhenBlockPresent(blockType: BlockType, blockLocation: BlockLocation, isPresent: Boolean = definedExternally)
    open fun succeedWhenEntityHasComponent(entityTypeIdentifier: String, componentIdentifier: String, blockLocation: BlockLocation, hasComponent: Boolean)
    open fun succeedWhenEntityPresent(entityTypeIdentifier: String, blockLocation: BlockLocation, isPresent: Boolean = definedExternally)
    open fun triggerInternalBlockEvent(blockLocation: BlockLocation, event: String, eventParameters: Array<Number> = definedExternally)
    open fun until(callback: () -> Unit): Promise<Unit>
    open fun walkTo(mob: Entity, blockLocation: BlockLocation, speedModifier: Number = definedExternally)
    open fun walkToLocation(mob: Entity, location: Location, speedModifier: Number = definedExternally)
    open fun worldBlockLocation(relativeBlockLocation: BlockLocation): BlockLocation
    open fun worldLocation(relativeLocation: Location): Location
}

external fun register(testClassName: String, testName: String, testFunction: (arg: Test) -> Unit): RegistrationBuilder

external fun registerAsync(testClassName: String, testName: String, testFunction: (arg: Test) -> Promise<Unit>): RegistrationBuilder