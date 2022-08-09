@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import externals.Iterable
import kotlin.js.Promise

external enum class Direction {
    down /* = 0 */,
    up /* = 1 */,
    north /* = 2 */,
    south /* = 3 */,
    west /* = 4 */,
    east /* = 5 */
}

external enum class GameMode {
    survival /* = 0 */,
    creative /* = 1 */,
    adventure /* = 2 */
}

external enum class ScoreboardIdentityType {
    player /* = 1 */,
    entity /* = 2 */,
    fakePlayer /* = 3 */
}

external open class BeforeChatEvent {
    open var cancel: Boolean
    open var message: String
    open var sender: Player
    open var sendToTargets: Boolean
    open var targets: Array<Player>
}

external open class BeforeChatEventSignal {
    open fun subscribe(callback: (arg: BeforeChatEvent) -> Unit): (arg: BeforeChatEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeChatEvent) -> Unit)
}

external open class BeforeDataDrivenEntityTriggerEvent {
    open var cancel: Boolean
    open var entity: Entity
    open var id: String
    open var modifiers: Array<DefinitionModifier>
}

external open class BeforeDataDrivenEntityTriggerEventSignal {
    open fun subscribe(callback: (arg: BeforeDataDrivenEntityTriggerEvent) -> Unit, options: EntityDataDrivenTriggerEventOptions = definedExternally): (arg: BeforeDataDrivenEntityTriggerEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeDataDrivenEntityTriggerEvent) -> Unit)
}

external open class BeforeExplosionEvent {
    open var cancel: Boolean
    open var dimension: Dimension
    open var impactedBlocks: Array<BlockLocation>
    open var source: Entity
}

external open class BeforeExplosionEventSignal {
    open fun subscribe(callback: (arg: BeforeExplosionEvent) -> Unit): (arg: BeforeExplosionEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeExplosionEvent) -> Unit)
}

external open class BeforeItemDefinitionEventSignal {
    open fun subscribe(callback: (arg: BeforeItemDefinitionTriggeredEvent) -> Unit): (arg: BeforeItemDefinitionTriggeredEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeItemDefinitionTriggeredEvent) -> Unit)
}

external open class BeforeItemDefinitionTriggeredEvent {
    open var cancel: Boolean
    open var eventName: String
    open var item: ItemStack
    open var source: Entity
}

external open class BeforeItemUseEvent {
    open var cancel: Boolean
    open var item: ItemStack
    open var source: Entity
}

external open class BeforeItemUseEventSignal {
    open fun subscribe(callback: (arg: BeforeItemUseEvent) -> Unit): (arg: BeforeItemUseEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeItemUseEvent) -> Unit)
}

external open class BeforeItemUseOnEvent {
    open var blockFace: Direction
    open var blockLocation: BlockLocation
    open var cancel: Boolean
    open var faceLocationX: Number
    open var faceLocationY: Number
    open var item: ItemStack
    open var source: Entity
}

external open class BeforeItemUseOnEventSignal {
    open fun subscribe(callback: (arg: BeforeItemUseOnEvent) -> Unit): (arg: BeforeItemUseOnEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforeItemUseOnEvent) -> Unit)
}

external open class BeforePistonActivateEvent : BlockEvent {
    override var block: Block
    open var cancel: Boolean
    override var dimension: Dimension
    open var isExpanding: Boolean
    open var piston: BlockPistonComponent
}

external open class BeforePistonActivateEventSignal {
    open fun subscribe(callback: (arg: BeforePistonActivateEvent) -> Unit): (arg: BeforePistonActivateEvent) -> Unit
    open fun unsubscribe(callback: (arg: BeforePistonActivateEvent) -> Unit)
}

external open class Block {
    open var dimension: Dimension
    open var id: String
    open var isEmpty: Boolean
    open var isWaterlogged: Boolean
    open var location: BlockLocation
    open var permutation: BlockPermutation
    open var type: BlockType
    open var x: Number
    open var y: Number
    open var z: Number
    open fun getComponent(componentName: String): Any
    open fun getTags(): Array<String>
    open fun hasTag(tag: String): Boolean
    open fun setPermutation(permutation: BlockPermutation)
    open fun setType(blockType: BlockType)
}

external open class BlockAreaSize(x: Number, y: Number, z: Number) {
    open var x: Number
    open var y: Number
    open var z: Number
    open fun equals(other: BlockAreaSize): Boolean
}

external open class BlockBreakEvent : BlockEvent {
    override var block: Block
    open var brokenBlockPermutation: BlockPermutation
    override var dimension: Dimension
    open var player: Player
}

external open class BlockBreakEventSignal {
    open fun subscribe(callback: (arg: BlockBreakEvent) -> Unit): (arg: BlockBreakEvent) -> Unit
    open fun unsubscribe(callback: (arg: BlockBreakEvent) -> Unit)
}

external open class BlockComponent

external open class BlockEvent {
    open var block: Block
    open var dimension: Dimension
}

external open class BlockExplodeEvent : BlockEvent {
    override var block: Block
    override var dimension: Dimension
    open var source: Entity
}

external open class BlockExplodeEventSignal {
    open fun subscribe(callback: (arg: BlockExplodeEvent) -> Unit): (arg: BlockExplodeEvent) -> Unit
    open fun unsubscribe(callback: (arg: BlockExplodeEvent) -> Unit)
}

external open class BlockHitInformation {
    open var block: Block
    open var face: Direction
    open var faceLocationX: Number
    open var faceLocationY: Number
}

external open class BlockInventoryComponent : BlockComponent {
    open var container: BlockInventoryComponentContainer
    open var location: BlockLocation
}

external open class BlockInventoryComponentContainer : Container {
    override var emptySlotsCount: Number
    override var size: Number
    override fun addItem(itemStack: ItemStack)
    override fun getItem(slot: Number): ItemStack
    override fun setItem(slot: Number, itemStack: ItemStack)
    override fun swapItems(slot: Number, otherSlot: Number, otherContainer: Container): Boolean
    override fun transferItem(fromSlot: Number, toSlot: Number, toContainer: Container): Boolean
}

external open class BlockLavaContainerComponent : BlockComponent {
    open var fillLevel: Number
    open var location: BlockLocation
}

external open class BlockLocation(x: Number, y: Number, z: Number) {
    open var x: Number
    open var y: Number
    open var z: Number
    open fun above(): BlockLocation
    open fun blocksBetween(other: BlockLocation): Array<BlockLocation>
    open fun equals(other: BlockLocation): Boolean
    open fun offset(x: Number, y: Number, z: Number): BlockLocation
}

external open class BlockPermutation {
    open var type: BlockType
    open fun clone(): BlockPermutation
    open fun getAllProperties(): Array<IBlockProperty>
    open fun getProperty(propertyName: String): IBlockProperty
    open fun getTags(): Array<String>
    open fun hasTag(tag: String): Boolean
}

external open class BlockPistonComponent : BlockComponent {
    open var attachedBlocks: Array<BlockLocation>
    open var isExpanded: Boolean
    open var isExpanding: Boolean
    open var isMoving: Boolean
    open var isRetracted: Boolean
    open var isRetracting: Boolean
    open var location: BlockLocation
}

external open class BlockPlaceEvent : BlockEvent {
    override var block: Block
    override var dimension: Dimension
    open var player: Player
}

external open class BlockPlaceEventSignal {
    open fun subscribe(callback: (arg: BlockPlaceEvent) -> Unit): (arg: BlockPlaceEvent) -> Unit
    open fun unsubscribe(callback: (arg: BlockPlaceEvent) -> Unit)
}

external open class BlockPotionContainerComponent : BlockComponent {
    open var fillLevel: Number
    open var location: BlockLocation
    open fun setPotionType(item: ItemStack)
}

external open class BlockProperties {
    companion object {
        var active: String = definedExternally
        var age: String = definedExternally
        var ageBit: String = definedExternally
        var allowUnderwaterBit: String = definedExternally
        var attachedBit: String = definedExternally
        var attachment: String = definedExternally
        var bambooLeafSize: String = definedExternally
        var bambooStalkThickness: String = definedExternally
        var bigDripleafHead: String = definedExternally
        var bigDripleafTilt: String = definedExternally
        var biteCounter: String = definedExternally
        var blockLightLevel: String = definedExternally
        var bloom: String = definedExternally
        var brewingStandSlotABit: String = definedExternally
        var brewingStandSlotBBit: String = definedExternally
        var brewingStandSlotCBit: String = definedExternally
        var buttonPressedBit: String = definedExternally
        var candles: String = definedExternally
        var canSummon: String = definedExternally
        var cauldronLiquid: String = definedExternally
        var chemistryTableType: String = definedExternally
        var chiselType: String = definedExternally
        var clusterCount: String = definedExternally
        var color: String = definedExternally
        var colorBit: String = definedExternally
        var composterFillLevel: String = definedExternally
        var conditionalBit: String = definedExternally
        var coralColor: String = definedExternally
        var coralDirection: String = definedExternally
        var coralFanDirection: String = definedExternally
        var coralHangTypeBit: String = definedExternally
        var coveredBit: String = definedExternally
        var crackedState: String = definedExternally
        var damage: String = definedExternally
        var deadBit: String = definedExternally
        var deprecated: String = definedExternally
        var direction: String = definedExternally
        var dirtType: String = definedExternally
        var disarmedBit: String = definedExternally
        var doorHingeBit: String = definedExternally
        var doublePlantType: String = definedExternally
        var dragDown: String = definedExternally
        var dripstoneThickness: String = definedExternally
        var endPortalEyeBit: String = definedExternally
        var explodeBit: String = definedExternally
        var extinguished: String = definedExternally
        var facingDirection: String = definedExternally
        var fillLevel: String = definedExternally
        var flowerType: String = definedExternally
        var groundSignDirection: String = definedExternally
        var growingPlantAge: String = definedExternally
        var growth: String = definedExternally
        var hanging: String = definedExternally
        var headPieceBit: String = definedExternally
        var height: String = definedExternally
        var honeyLevel: String = definedExternally
        var hugeMushroomBits: String = definedExternally
        var infiniburnBit: String = definedExternally
        var inWallBit: String = definedExternally
        var itemFrameMapBit: String = definedExternally
        var itemFramePhotoBit: String = definedExternally
        var kelpAge: String = definedExternally
        var leverDirection: String = definedExternally
        var liquidDepth: String = definedExternally
        var lit: String = definedExternally
        var moisturizedAmount: String = definedExternally
        var monsterEggStoneType: String = definedExternally
        var multiFaceDirectionBits: String = definedExternally
        var newLeafType: String = definedExternally
        var newLogType: String = definedExternally
        var noDropBit: String = definedExternally
        var occupiedBit: String = definedExternally
        var oldLeafType: String = definedExternally
        var oldLogType: String = definedExternally
        var openBit: String = definedExternally
        var outputLitBit: String = definedExternally
        var outputSubtractBit: String = definedExternally
        var persistentBit: String = definedExternally
        var pillarAxis: String = definedExternally
        var portalAxis: String = definedExternally
        var poweredBit: String = definedExternally
        var prismarineBlockType: String = definedExternally
        var propaguleStage: String = definedExternally
        var railDataBit: String = definedExternally
        var railDirection: String = definedExternally
        var redstoneSignal: String = definedExternally
        var repeaterDelay: String = definedExternally
        var respawnAnchorCharge: String = definedExternally
        var rotation: String = definedExternally
        var sandStoneType: String = definedExternally
        var sandType: String = definedExternally
        var saplingType: String = definedExternally
        var seaGrassType: String = definedExternally
        var spongeType: String = definedExternally
        var stability: String = definedExternally
        var stabilityCheck: String = definedExternally
        var stoneBrickType: String = definedExternally
        var stoneSlabType: String = definedExternally
        var stoneSlabType2: String = definedExternally
        var stoneSlabType3: String = definedExternally
        var stoneSlabType4: String = definedExternally
        var stoneType: String = definedExternally
        var strippedBit: String = definedExternally
        var structureBlockType: String = definedExternally
        var structureVoidType: String = definedExternally
        var suspendedBit: String = definedExternally
        var tallGrassType: String = definedExternally
        var toggleBit: String = definedExternally
        var topSlotBit: String = definedExternally
        var torchFacingDirection: String = definedExternally
        var triggeredBit: String = definedExternally
        var turtleEggCount: String = definedExternally
        var twistingVinesAge: String = definedExternally
        var updateBit: String = definedExternally
        var upperBlockBit: String = definedExternally
        var upsideDownBit: String = definedExternally
        var vineDirectionBits: String = definedExternally
        var wallBlockType: String = definedExternally
        var wallConnectionTypeEast: String = definedExternally
        var wallConnectionTypeNorth: String = definedExternally
        var wallConnectionTypeSouth: String = definedExternally
        var wallConnectionTypeWest: String = definedExternally
        var wallPostBit: String = definedExternally
        var weepingVinesAge: String = definedExternally
        var weirdoDirection: String = definedExternally
        var woodType: String = definedExternally
    }
}

external open class BlockRaycastOptions {
    open var includeLiquidBlocks: Boolean
    open var includePassableBlocks: Boolean
    open var maxDistance: Number
}

external open class BlockRecordPlayerComponent {
    open fun clearRecord()
    open fun isPlaying(): Boolean
    open fun setRecord(recordItemType: ItemType)
}

external open class BlockSnowContainerComponent : BlockComponent {
    open var fillLevel: Number
    open var location: BlockLocation
}

external open class BlockType {
    open var canBeWaterlogged: Boolean
    open var id: String
    open fun createDefaultBlockPermutation(): BlockPermutation
}

external open class BlockWaterContainerComponent : BlockComponent {
    open var customColor: Color
    open var fillLevel: Number
    open var location: BlockLocation
    open fun addDye(itemType: ItemType)
}

external open class BoolBlockProperty : IBlockProperty {
    override var name: String
    open var validValues: Array<Boolean>
    open var value: Boolean
}

external open class ButtonPushEvent : BlockEvent {
    override var block: Block
    override var dimension: Dimension
    open var source: Entity
}

external open class ButtonPushEventSignal {
    open fun subscribe(callback: (arg: ButtonPushEvent) -> Unit): (arg: ButtonPushEvent) -> Unit
    open fun unsubscribe(callback: (arg: ButtonPushEvent) -> Unit)
}

external open class ChatEvent {
    open var message: String
    open var sender: Player
    open var sendToTargets: Boolean
    open var targets: Array<Player>
}

external open class ChatEventSignal {
    open fun subscribe(callback: (arg: ChatEvent) -> Unit): (arg: ChatEvent) -> Unit
    open fun unsubscribe(callback: (arg: ChatEvent) -> Unit)
}

external open class Color(red: Number, green: Number, blue: Number, alpha: Number) {
    open var alpha: Number
    open var blue: Number
    open var green: Number
    open var red: Number
}

external open class CommandResult {
    open var successCount: Number
}

external open class Container {
    open var emptySlotsCount: Number
    open var size: Number
    open fun addItem(itemStack: ItemStack)
    open fun getItem(slot: Number): ItemStack
    open fun setItem(slot: Number, itemStack: ItemStack)
    open fun swapItems(slot: Number, otherSlot: Number, otherContainer: Container): Boolean
    open fun transferItem(fromSlot: Number, toSlot: Number, toContainer: Container): Boolean
}

external open class DataDrivenEntityTriggerEvent {
    open var entity: Entity
    open var id: String
    open var modifiers: Array<DefinitionModifier>
}

external open class DataDrivenEntityTriggerEventSignal {
    open fun subscribe(callback: (arg: DataDrivenEntityTriggerEvent) -> Unit, options: EntityDataDrivenTriggerEventOptions = definedExternally): (arg: DataDrivenEntityTriggerEvent) -> Unit
    open fun unsubscribe(callback: (arg: DataDrivenEntityTriggerEvent) -> Unit)
}

external open class DefinitionModifier {
    open var componentGroupsToAdd: Array<String>
    open var componentGroupsToRemove: Array<String>
    open var triggers: Array<Trigger>
}

external open class Dimension {
    open var id: String
    open fun createExplosion(location: Location, radius: Number, explosionOptions: ExplosionOptions)
    open fun getBlock(location: BlockLocation): Block
    open fun getBlockFromRay(location: Location, direction: Vector, options: BlockRaycastOptions = definedExternally): Block
    open fun getEntities(getEntities: EntityQueryOptions = definedExternally): EntityIterator
    open fun getEntitiesAtBlockLocation(location: BlockLocation): Array<Entity>
    open fun getEntitiesFromRay(location: Location, direction: Vector, options: EntityRaycastOptions = definedExternally): Array<Entity>
    open fun getPlayers(getPlayers: EntityQueryOptions = definedExternally): PlayerIterator
    open fun isEmpty(location: BlockLocation): Boolean
    open fun runCommand(commandString: String): Any
    open fun runCommandAsync(commandString: String): Promise<CommandResult>
    open fun spawnEntity(identifier: String, location: BlockLocation): Entity
    open fun spawnEntity(identifier: String, location: Location): Entity
    open fun spawnItem(item: ItemStack, location: BlockLocation): Entity
    open fun spawnItem(item: ItemStack, location: Location): Entity
    open fun spawnParticle(effectName: String, location: Location, molangVariables: MolangVariableMap)
}

external open class DynamicPropertiesDefinition {
    open fun defineBoolean(identifier: String)
    open fun defineNumber(identifier: String)
    open fun defineString(identifier: String, maxLength: Number)
}

external open class Effect {
    open var amplifier: Number
    open var displayName: String
    open var duration: Number
}

external open class EffectAddEvent {
    open var effect: Effect
    open var effectState: Number
    open var entity: Entity
}

external open class EffectAddEventSignal {
    open fun subscribe(callback: (arg: EffectAddEvent) -> Unit, options: EntityEventOptions = definedExternally): (arg: EffectAddEvent) -> Unit
    open fun unsubscribe(callback: (arg: EffectAddEvent) -> Unit)
}

external open class EffectType {
    open fun getName(): String
}

external open class Enchantment(enchantmentType: EnchantmentType, level: Number = definedExternally) {
    open var level: Number
    open var type: EnchantmentType
}

typealias EnchantmentList = Iterable<Enchantment>

external open class EnchantmentSlot {
    companion object {
        var all: Int = definedExternally
        var armorFeet: Int = definedExternally
        var armorHead: Int = definedExternally
        var armorLegs: Int = definedExternally
        var armorTorso: Int = definedExternally
        var axe: Int = definedExternally
        var bow: Int = definedExternally
        var carrotStick: Int = definedExternally
        var cosmeticHead: Int = definedExternally
        var crossbow: Int = definedExternally
        var elytra: Int = definedExternally
        var fishingRod: Int = definedExternally
        var flintsteel: Int = definedExternally
        var gArmor: Int = definedExternally
        var gDigging: Int = definedExternally
        var gTool: Int = definedExternally
        var hoe: Int = definedExternally
        var none: Int = definedExternally
        var pickaxe: Int = definedExternally
        var shears: Int = definedExternally
        var shield: Int = definedExternally
        var shovel: Int = definedExternally
        var spear: Int = definedExternally
        var sword: Int = definedExternally
    }
}

external open class EnchantmentType {
    open var id: String
    open var maxLevel: Number
}

external open class Entity {
    open var dimension: Dimension
    open var headLocation: Location
    open var id: String
    open var isSneaking: Boolean
    open var location: Location
    open var nameTag: String
    open var rotation: XYRotation
    open var scoreboard: ScoreboardIdentity
    open var target: Entity
    open var velocity: Vector
    open var viewVector: Vector
    open fun addEffect(effectType: EffectType, duration: Number, amplifier: Number = definedExternally, showParticles: Boolean = definedExternally)
    open fun addTag(tag: String): Boolean
    open fun getBlockFromViewVector(options: BlockRaycastOptions = definedExternally): Block
    open fun getComponent(componentId: String): IEntityComponent
    open fun getComponents(): Array<IEntityComponent>
    open fun getDynamicProperty(identifier: String): dynamic /* Boolean | Number | String */
    open fun getEffect(effectType: EffectType): Effect
    open fun getEntitiesFromViewVector(options: EntityRaycastOptions = definedExternally): Array<Entity>
    open fun getTags(): Array<String>
    open fun hasComponent(componentId: String): Boolean
    open fun hasTag(tag: String): Boolean
    open fun kill()
    open fun removeDynamicProperty(identifier: String): Boolean
    open fun removeTag(tag: String): Boolean
    open fun runCommand(commandString: String): Any
    open fun runCommandAsync(commandString: String): Promise<CommandResult>
    open fun setDynamicProperty(identifier: String, value: Boolean)
    open fun setDynamicProperty(identifier: String, value: Number)
    open fun setDynamicProperty(identifier: String, value: String)
    open fun setRotation(degreesX: Number, degreesY: Number)
    open fun setVelocity(velocity: Vector)
    open fun teleport(location: Location, dimension: Dimension, xRotation: Number, yRotation: Number, keepVelocity: Boolean = definedExternally)
    open fun teleportFacing(location: Location, dimension: Dimension, facingLocation: Location, keepVelocity: Boolean = definedExternally)
    open fun triggerEvent(eventName: String)
}

external open class EntityAddRiderComponent : IEntityComponent {
    open var entityType: String
    override var id: String
    open var spawnEvent: String
}

external open class EntityAgeableComponent : IEntityComponent {
    open var dropItems: Array<String>
    open var duration: Number
    open var feedItems: Array<EntityDefinitionFeedItem>
    open var growUp: Trigger
    override var id: String
}

external open class EntityBreathableComponent : IEntityComponent {
    open var breatheBlocks: Array<BlockPermutation>
    open var breathesAir: Boolean
    open var breathesLava: Boolean
    open var breathesSolids: Boolean
    open var breathesWater: Boolean
    open var generatesBubbles: Boolean
    override var id: String
    open var inhaleTime: Number
    open var nonBreatheBlocks: Array<BlockPermutation>
    open var suffocateTime: Number
    open var totalSupply: Number
    open fun setAirSupply(value: Number)
}

external open class EntityCanClimbComponent : IEntityComponent {
    override var id: String
}

external open class EntityCanFlyComponent : IEntityComponent {
    override var id: String
}

external open class EntityCanPowerJumpComponent : IEntityComponent {
    override var id: String
}

external open class EntityColorComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityCreateEvent {
    open var entity: Entity
}

external open class EntityCreateEventSignal {
    open fun subscribe(callback: (arg: EntityCreateEvent) -> Unit): (arg: EntityCreateEvent) -> Unit
    open fun unsubscribe(callback: (arg: EntityCreateEvent) -> Unit)
}

external open class EntityDataDrivenTriggerEventOptions {
    open var entities: Array<Entity>
    open var entityTypes: Array<String>
    open var eventTypes: Array<String>
}

external open class EntityDefinitionFeedItem {
    open var growth: Number
    open var item: String
}

external open class EntityEventOptions {
    open var entities: Array<Entity>
    open var entityTypes: Array<String>
}

external open class EntityFireImmuneComponent : IEntityComponent {
    override var id: String
}

external open class EntityFloatsInLiquidComponent : IEntityComponent {
    override var id: String
}

external open class EntityFlyingSpeedComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityFrictionModifierComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityGroundOffsetComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityHealableComponent : IEntityComponent {
    open var filters: FilterGroup
    open var forceUse: Boolean
    override var id: String
    open var items: Array<FeedItem>
}

external open class EntityHealthComponent : IEntityComponent {
    open var current: Number
    override var id: String
    open var value: Number
    open fun resetToDefaultValue()
    open fun resetToMaxValue()
    open fun resetToMinValue()
    open fun setCurrent(value: Number)
}

external open class EntityHitEvent {
    open var entity: Entity
    open var hitBlock: Block
    open var hitEntity: Entity
}

external open class EntityHitEventSignal {
    open fun subscribe(callback: (arg: EntityHitEvent) -> Unit, options: EntityEventOptions = definedExternally): (arg: EntityHitEvent) -> Unit
    open fun unsubscribe(callback: (arg: EntityHitEvent) -> Unit)
}

external open class EntityHitInformation {
    open var entity: Entity
}

external open class EntityHurtEvent {
    open var cause: String
    open var damage: Number
    open var damagingEntity: Entity
    open var hurtEntity: Entity
    open var projectile: Entity
}

external open class EntityHurtEventSignal {
    open fun subscribe(callback: (arg: EntityHurtEvent) -> Unit, options: EntityEventOptions = definedExternally): (arg: EntityHurtEvent) -> Unit
    open fun unsubscribe(callback: (arg: EntityHurtEvent) -> Unit)
}

external open class EntityInventoryComponent : IEntityComponent {
    open var additionalSlotsPerStrength: Number
    open var canBeSiphonedFrom: Boolean
    open var container: InventoryComponentContainer
    open var containerType: String
    override var id: String
    open var inventorySize: Number
    open var private: Boolean
    open var restrictToOwner: Boolean
}

external open class EntityIsBabyComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsChargedComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsChestedComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsDyableComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsHiddenWhenInvisibleComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsIgnitedComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsIllagerCaptainComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsSaddledComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsShakingComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsShearedComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsStackableComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsStunnedComponent : IEntityComponent {
    override var id: String
}

external open class EntityIsTamedComponent : IEntityComponent {
    override var id: String
}

external open class EntityItemComponent {
    open var itemStack: ItemStack
}

typealias EntityIterator = Iterable<Entity>

external open class EntityLavaMovementComponent : IEntityComponent {
    open var current: Number
    override var id: String
    open var value: Number
    open fun resetToDefaultValue()
    open fun resetToMaxValue()
    open fun resetToMinValue()
    open fun setCurrent(value: Number)
}

external open class EntityLeashableComponent : IEntityComponent {
    override var id: String
    open var softDistance: Number
    open fun leash(leashHolder: Entity)
    open fun unleash()
}

external open class EntityMarkVariantComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityMountTamingComponent : IEntityComponent {
    override var id: String
    open fun setTamed(showParticles: Boolean)
}

external open class EntityMovementAmphibiousComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementBasicComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementComponent : IEntityComponent {
    open var current: Number
    override var id: String
    open var value: Number
    open fun resetToDefaultValue()
    open fun resetToMaxValue()
    open fun resetToMinValue()
    open fun setCurrent(value: Number)
}

external open class EntityMovementFlyComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementGenericComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementGlideComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
    open var speedWhenTurning: Number
    open var startSpeed: Number
}

external open class EntityMovementHoverComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementJumpComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementSkipComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
}

external open class EntityMovementSwayComponent : IEntityComponent {
    override var id: String
    open var maxTurn: Number
    open var swayAmplitude: Number
    open var swayFrequency: Number
}

external open class EntityNavigationClimbComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityNavigationFloatComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityNavigationFlyComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityNavigationGenericComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityNavigationHoverComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityNavigationWalkComponent : IEntityComponent {
    open var avoidDamageBlocks: Boolean
    open var avoidPortals: Boolean
    open var avoidSun: Boolean
    open var avoidWater: Boolean
    open var canBreach: Boolean
    open var canBreakDoors: Boolean
    open var canFloat: Boolean
    open var canJump: Boolean
    open var canOpenDoors: Boolean
    open var canOpenIronDoors: Boolean
    open var canPassDoors: Boolean
    open var canPathFromAir: Boolean
    open var canPathOverLava: Boolean
    open var canPathOverWater: Boolean
    open var canSink: Boolean
    open var canSwim: Boolean
    open var canWalk: Boolean
    open var canWalkInLava: Boolean
    override var id: String
    open var isAmphibious: Boolean
}

external open class EntityPushThroughComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityQueryOptions {
    open var closest: Number
    open var excludeFamilies: Array<String>
    open var excludeGameModes: Array<GameMode>
    open var excludeNames: Array<String>
    open var excludeTags: Array<String>
    open var excludeTypes: Array<String>
    open var families: Array<String>
    open var farthest: Number
    open var gameMode: GameMode
    open var location: Location
    open var maxDistance: Number
    open var maxHorizontalRotation: Number
    open var maxLevel: Number
    open var maxVerticalRotation: Number
    open var minDistance: Number
    open var minHorizontalRotation: Number
    open var minLevel: Number
    open var minVerticalRotation: Number
    open var name: String
    open var scoreOptions: Array<EntityQueryScoreOptions>
    open var tags: Array<String>
    open var type: String
    open var volume: BlockAreaSize
}

external open class EntityQueryScoreOptions {
    open var exclude: Boolean
    open var maxScore: Number
    open var minScore: Number
    open var objective: String
}

external open class EntityRaycastOptions {
    open var maxDistance: Number
}

external open class EntityRideableComponent : IEntityComponent {
    open var controllingSeat: Number
    open var crouchingSkipInteract: Boolean
    open var familyTypes: Array<String>
    override var id: String
    open var interactText: String
    open var pullInEntities: Boolean
    open var riderCanInteract: Boolean
    open var seatCount: Number
    open var seats: Array<Seat>
    open fun addRider(rider: Entity): Boolean
    open fun ejectRider(rider: Entity)
    open fun ejectRiders()
}

external open class EntityScaleComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntitySkinIdComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityStrengthComponent : IEntityComponent {
    override var id: String
    open var max: Number
    open var value: Number
}

external open class EntityTameableComponent : IEntityComponent {
    override var id: String
    open var probability: Number
    open var tameEvent: Trigger
    open var tameItems: Array<String>
    open fun tame(): Boolean
}

external open class EntityType {
    open var id: String
}

typealias EntityTypeIterator = Iterable<EntityType>

external open class EntityTypes {
    companion object {
        fun get(identifier: String): EntityType
        fun getAll(): EntityTypeIterator
    }
}

external open class EntityUnderwaterMovementComponent : IEntityComponent {
    open var current: Number
    override var id: String
    open var value: Number
    open fun resetToDefaultValue()
    open fun resetToMaxValue()
    open fun resetToMinValue()
    open fun setCurrent(value: Number)
}

external open class EntityVariantComponent : IEntityComponent {
    override var id: String
    open var value: Number
}

external open class EntityWantsJockeyComponent : IEntityComponent {
    override var id: String
}

external open class Events {
    open var beforeChat: BeforeChatEventSignal
    open var beforeDataDrivenEntityTriggerEvent: BeforeDataDrivenEntityTriggerEventSignal
    open var beforeExplosion: BeforeExplosionEventSignal
    open var beforeItemDefinitionEvent: BeforeItemDefinitionEventSignal
    open var beforeItemUse: BeforeItemUseEventSignal
    open var beforeItemUseOn: BeforeItemUseOnEventSignal
    open var beforePistonActivate: BeforePistonActivateEventSignal
    open var blockBreak: BlockBreakEventSignal
    open var blockExplode: BlockExplodeEventSignal
    open var blockPlace: BlockPlaceEventSignal
    open var buttonPush: ButtonPushEventSignal
    open var chat: ChatEventSignal
    open var dataDrivenEntityTriggerEvent: DataDrivenEntityTriggerEventSignal
    open var effectAdd: EffectAddEventSignal
    open var entityCreate: EntityCreateEventSignal
    open var entityHit: EntityHitEventSignal
    open var entityHurt: EntityHurtEventSignal
    open var explosion: ExplosionEventSignal
    open var itemCompleteCharge: ItemCompleteChargeEventSignal
    open var itemDefinitionEvent: ItemDefinitionEventSignal
    open var itemReleaseCharge: ItemReleaseChargeEventSignal
    open var itemStartCharge: ItemStartChargeEventSignal
    open var itemStartUseOn: ItemStartUseOnEventSignal
    open var itemStopCharge: ItemStopChargeEventSignal
    open var itemStopUseOn: ItemStopUseOnEventSignal
    open var itemUse: ItemUseEventSignal
    open var itemUseOn: ItemUseOnEventSignal
    open var leverActivate: LeverActionEventSignal
    open var pistonActivate: PistonActivateEventSignal
    open var playerJoin: PlayerJoinEventSignal
    open var playerLeave: PlayerLeaveEventSignal
    open var projectileHit: ProjectileHitEventSignal
    open var tick: TickEventSignal
    open var weatherChange: WeatherChangeEventSignal
    open var worldInitialize: WorldInitializeEventSignal
}

external open class ExplosionEvent {
    open var dimension: Dimension
    open var impactedBlocks: Array<BlockLocation>
    open var source: Entity
}

external open class ExplosionEventSignal {
    open fun subscribe(callback: (arg: ExplosionEvent) -> Unit): (arg: ExplosionEvent) -> Unit
    open fun unsubscribe(callback: (arg: ExplosionEvent) -> Unit)
}

external open class ExplosionOptions {
    open var allowUnderwater: Boolean
    open var breaksBlocks: Boolean
    open var causesFire: Boolean
    open var source: Entity
}

external open class FeedItem {
    open var effects: Array<FeedItemEffect>
    open var healAmount: Number
    open var item: String
}

external open class FeedItemEffect {
    open var amplifier: Number
    open var chance: Number
    open var duration: Number
    open var name: String
}

external open class FilterGroup

external open class FluidContainer {
    companion object {
        var maxFillLevel: Int = definedExternally
        var minFillLevel: Int = definedExternally
    }
}

external open class IBlockProperty {
    open var name: String
}

external open class IEntityComponent {
    open var id: String
}

external open class IntBlockProperty : IBlockProperty {
    override var name: String
    open var validValues: Array<Number>
    open var value: Number
}

external open class InventoryComponentContainer : Container {
    override var emptySlotsCount: Number
    override var size: Number
    override fun addItem(itemStack: ItemStack)
    override fun getItem(slot: Number): ItemStack
    override fun setItem(slot: Number, itemStack: ItemStack)
    override fun swapItems(slot: Number, otherSlot: Number, otherContainer: Container): Boolean
    override fun transferItem(fromSlot: Number, toSlot: Number, toContainer: Container): Boolean
}

external open class ItemCompleteChargeEvent {
    open var itemStack: ItemStack
    open var source: Entity
    open var useDuration: Number
}

external open class ItemCompleteChargeEventSignal {
    open fun subscribe(callback: (arg: ItemCompleteChargeEvent) -> Unit): (arg: ItemCompleteChargeEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemCompleteChargeEvent) -> Unit)
}

external open class ItemCooldownComponent {
    open var cooldownCategory: String
    open var cooldownTicks: Number
    open var id: String
    open fun startCooldown(player: Player)
}

external open class ItemDefinitionEventSignal {
    open fun subscribe(callback: (arg: ItemDefinitionTriggeredEvent) -> Unit): (arg: ItemDefinitionTriggeredEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemDefinitionTriggeredEvent) -> Unit)
}

external open class ItemDefinitionTriggeredEvent {
    open var eventName: String
    open var item: ItemStack
    open var source: Entity
}

external open class ItemDurabilityComponent {
    open var damage: Number
    open var damageRange: NumberRange
    open var id: String
    open var maxDurability: Number
    open fun getDamageChance(unbreaking: Number = definedExternally): Number
}

external open class ItemEnchantsComponent {
    open var enchantments: EnchantmentList
    open var id: String
    open fun removeAllEnchantments()
}

external open class ItemFoodComponent {
    open var canAlwaysEat: Boolean
    open var id: String
    open var nutrition: Number
    open var saturationModifier: Number
    open var usingConvertsTo: String
}

external open class ItemReleaseChargeEvent {
    open var itemStack: ItemStack
    open var source: Entity
    open var useDuration: Number
}

external open class ItemReleaseChargeEventSignal {
    open fun subscribe(callback: (arg: ItemReleaseChargeEvent) -> Unit): (arg: ItemReleaseChargeEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemReleaseChargeEvent) -> Unit)
}

external open class Items {
    companion object {
        fun get(itemId: String): ItemType
    }
}

external open class ItemStack(itemType: ItemType, amount: Number = definedExternally, data: Number = definedExternally) {
    open var amount: Number
    open var data: Number
    open var id: String
    open var nameTag: String
    open fun getComponent(componentId: String): Any
    open fun getComponents(): Array<Any>
    open fun getLore(): Array<String>
    open fun hasComponent(componentId: String): Boolean
    open fun setLore(loreList: Array<String>)
    open fun triggerEvent(eventName: String)
}

external open class ItemStartChargeEvent {
    open var itemStack: ItemStack
    open var source: Entity
    open var useDuration: Number
}

external open class ItemStartChargeEventSignal {
    open fun subscribe(callback: (arg: ItemStartChargeEvent) -> Unit): (arg: ItemStartChargeEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemStartChargeEvent) -> Unit)
}

external open class ItemStartUseOnEvent {
    open var blockFace: Direction
    open var blockLocation: BlockLocation
    open var buildBlockLocation: BlockLocation
    open var item: ItemStack
    open var source: Entity
}

external open class ItemStartUseOnEventSignal {
    open fun subscribe(callback: (arg: ItemStartUseOnEvent) -> Unit): (arg: ItemStartUseOnEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemStartUseOnEvent) -> Unit)
}

external open class ItemStopChargeEvent {
    open var itemStack: ItemStack
    open var source: Entity
    open var useDuration: Number
}

external open class ItemStopChargeEventSignal {
    open fun subscribe(callback: (arg: ItemStopChargeEvent) -> Unit): (arg: ItemStopChargeEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemStopChargeEvent) -> Unit)
}

external open class ItemStopUseOnEvent {
    open var blockLocation: BlockLocation
    open var item: ItemStack
    open var source: Entity
}

external open class ItemStopUseOnEventSignal {
    open fun subscribe(callback: (arg: ItemStopUseOnEvent) -> Unit): (arg: ItemStopUseOnEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemStopUseOnEvent) -> Unit)
}

external open class ItemType {
    open var id: String
}

external open class ItemUseEvent {
    open var item: ItemStack
    open var source: Entity
}

external open class ItemUseEventSignal {
    open fun subscribe(callback: (arg: ItemUseEvent) -> Unit): (arg: ItemUseEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemUseEvent) -> Unit)
}

external open class ItemUseOnEvent {
    open var blockFace: Direction
    open var blockLocation: BlockLocation
    open var faceLocationX: Number
    open var faceLocationY: Number
    open var item: ItemStack
    open var source: Entity
}

external open class ItemUseOnEventSignal {
    open fun subscribe(callback: (arg: ItemUseOnEvent) -> Unit): (arg: ItemUseOnEvent) -> Unit
    open fun unsubscribe(callback: (arg: ItemUseOnEvent) -> Unit)
}

external open class LeverActionEvent : BlockEvent {
    override var block: Block
    override var dimension: Dimension
    open var isPowered: Boolean
    open var player: Player
}

external open class LeverActionEventSignal {
    open fun subscribe(callback: (arg: LeverActionEvent) -> Unit): (arg: LeverActionEvent) -> Unit
    open fun unsubscribe(callback: (arg: LeverActionEvent) -> Unit)
}

external open class Location(x: Number, y: Number, z: Number) {
    open var x: Number
    open var y: Number
    open var z: Number
    open fun equals(other: Location): Boolean
    open fun isNear(other: Location, epsilon: Number): Boolean
}

external open class MinecraftBlockTypes {
    companion object {
        var acaciaButton: BlockType
        var acaciaDoor: BlockType
        var acaciaFenceGate: BlockType
        var acaciaPressurePlate: BlockType
        var acaciaStairs: BlockType
        var acaciaStandingSign: BlockType
        var acaciaTrapdoor: BlockType
        var acaciaWallSign: BlockType
        var activatorRail: BlockType
        var air: BlockType
        var allow: BlockType
        var amethystBlock: BlockType
        var amethystCluster: BlockType
        var ancientDebris: BlockType
        var andesiteStairs: BlockType
        var anvil: BlockType
        var azalea: BlockType
        var azaleaLeaves: BlockType
        var azaleaLeavesFlowered: BlockType
        var bamboo: BlockType
        var bambooSapling: BlockType
        var barrel: BlockType
        var barrier: BlockType
        var basalt: BlockType
        var beacon: BlockType
        var bed: BlockType
        var bedrock: BlockType
        var beehive: BlockType
        var beeNest: BlockType
        var beetroot: BlockType
        var bell: BlockType
        var bigDripleaf: BlockType
        var birchButton: BlockType
        var birchDoor: BlockType
        var birchFenceGate: BlockType
        var birchPressurePlate: BlockType
        var birchStairs: BlockType
        var birchStandingSign: BlockType
        var birchTrapdoor: BlockType
        var birchWallSign: BlockType
        var blackCandle: BlockType
        var blackCandleCake: BlockType
        var blackGlazedTerracotta: BlockType
        var blackstone: BlockType
        var blackstoneDoubleSlab: BlockType
        var blackstoneSlab: BlockType
        var blackstoneStairs: BlockType
        var blackstoneWall: BlockType
        var blastFurnace: BlockType
        var blueCandle: BlockType
        var blueCandleCake: BlockType
        var blueGlazedTerracotta: BlockType
        var blueIce: BlockType
        var boneBlock: BlockType
        var bookshelf: BlockType
        var borderBlock: BlockType
        var brewingStand: BlockType
        var brickBlock: BlockType
        var brickStairs: BlockType
        var brownCandle: BlockType
        var brownCandleCake: BlockType
        var brownGlazedTerracotta: BlockType
        var brownMushroom: BlockType
        var brownMushroomBlock: BlockType
        var bubbleColumn: BlockType
        var buddingAmethyst: BlockType
        var cactus: BlockType
        var cake: BlockType
        var calcite: BlockType
        var camera: BlockType
        var campfire: BlockType
        var candle: BlockType
        var candleCake: BlockType
        var carpet: BlockType
        var carrots: BlockType
        var cartographyTable: BlockType
        var carvedPumpkin: BlockType
        var cauldron: BlockType
        var caveVines: BlockType
        var caveVinesBodyWithBerries: BlockType
        var caveVinesHeadWithBerries: BlockType
        var chain: BlockType
        var chainCommandBlock: BlockType
        var chemicalHeat: BlockType
        var chemistryTable: BlockType
        var chest: BlockType
        var chiseledDeepslate: BlockType
        var chiseledNetherBricks: BlockType
        var chiseledPolishedBlackstone: BlockType
        var chorusFlower: BlockType
        var chorusPlant: BlockType
        var clay: BlockType
        var clientRequestPlaceholderBlock: BlockType
        var coalBlock: BlockType
        var coalOre: BlockType
        var cobbledDeepslate: BlockType
        var cobbledDeepslateDoubleSlab: BlockType
        var cobbledDeepslateSlab: BlockType
        var cobbledDeepslateStairs: BlockType
        var cobbledDeepslateWall: BlockType
        var cobblestone: BlockType
        var cobblestoneWall: BlockType
        var cocoa: BlockType
        var coloredTorchBp: BlockType
        var coloredTorchRg: BlockType
        var commandBlock: BlockType
        var composter: BlockType
        var concrete: BlockType
        var concretePowder: BlockType
        var conduit: BlockType
        var copperBlock: BlockType
        var copperOre: BlockType
        var coral: BlockType
        var coralBlock: BlockType
        var coralFan: BlockType
        var coralFanDead: BlockType
        var coralFanHang: BlockType
        var coralFanHang2: BlockType
        var coralFanHang3: BlockType
        var crackedDeepslateBricks: BlockType
        var crackedDeepslateTiles: BlockType
        var crackedNetherBricks: BlockType
        var crackedPolishedBlackstoneBricks: BlockType
        var craftingTable: BlockType
        var crimsonButton: BlockType
        var crimsonDoor: BlockType
        var crimsonDoubleSlab: BlockType
        var crimsonFence: BlockType
        var crimsonFenceGate: BlockType
        var crimsonFungus: BlockType
        var crimsonHyphae: BlockType
        var crimsonNylium: BlockType
        var crimsonPlanks: BlockType
        var crimsonPressurePlate: BlockType
        var crimsonRoots: BlockType
        var crimsonSlab: BlockType
        var crimsonStairs: BlockType
        var crimsonStandingSign: BlockType
        var crimsonStem: BlockType
        var crimsonTrapdoor: BlockType
        var crimsonWallSign: BlockType
        var cryingObsidian: BlockType
        var cutCopper: BlockType
        var cutCopperSlab: BlockType
        var cutCopperStairs: BlockType
        var cyanCandle: BlockType
        var cyanCandleCake: BlockType
        var cyanGlazedTerracotta: BlockType
        var darkOakButton: BlockType
        var darkOakDoor: BlockType
        var darkOakFenceGate: BlockType
        var darkOakPressurePlate: BlockType
        var darkOakStairs: BlockType
        var darkoakStandingSign: BlockType
        var darkOakTrapdoor: BlockType
        var darkoakWallSign: BlockType
        var darkPrismarineStairs: BlockType
        var daylightDetector: BlockType
        var daylightDetectorInverted: BlockType
        var deadbush: BlockType
        var deepslate: BlockType
        var deepslateBrickDoubleSlab: BlockType
        var deepslateBricks: BlockType
        var deepslateBrickSlab: BlockType
        var deepslateBrickStairs: BlockType
        var deepslateBrickWall: BlockType
        var deepslateCoalOre: BlockType
        var deepslateCopperOre: BlockType
        var deepslateDiamondOre: BlockType
        var deepslateEmeraldOre: BlockType
        var deepslateGoldOre: BlockType
        var deepslateIronOre: BlockType
        var deepslateLapisOre: BlockType
        var deepslateRedstoneOre: BlockType
        var deepslateTileDoubleSlab: BlockType
        var deepslateTiles: BlockType
        var deepslateTileSlab: BlockType
        var deepslateTileStairs: BlockType
        var deepslateTileWall: BlockType
        var deny: BlockType
        var detectorRail: BlockType
        var diamondBlock: BlockType
        var diamondOre: BlockType
        var dioriteStairs: BlockType
        var dirt: BlockType
        var dirtWithRoots: BlockType
        var dispenser: BlockType
        var doubleCutCopperSlab: BlockType
        var doublePlant: BlockType
        var doubleStoneBlockSlab: BlockType
        var doubleStoneBlockSlab2: BlockType
        var doubleStoneBlockSlab3: BlockType
        var doubleStoneBlockSlab4: BlockType
        var doubleStoneSlab: BlockType
        var doubleStoneSlab2: BlockType
        var doubleStoneSlab3: BlockType
        var doubleStoneSlab4: BlockType
        var doubleWoodenSlab: BlockType
        var dragonEgg: BlockType
        var driedKelpBlock: BlockType
        var dripstoneBlock: BlockType
        var dropper: BlockType
        var element0: BlockType
        var element1: BlockType
        var element10: BlockType
        var element100: BlockType
        var element101: BlockType
        var element102: BlockType
        var element103: BlockType
        var element104: BlockType
        var element105: BlockType
        var element106: BlockType
        var element107: BlockType
        var element108: BlockType
        var element109: BlockType
        var element11: BlockType
        var element110: BlockType
        var element111: BlockType
        var element112: BlockType
        var element113: BlockType
        var element114: BlockType
        var element115: BlockType
        var element116: BlockType
        var element117: BlockType
        var element118: BlockType
        var element12: BlockType
        var element13: BlockType
        var element14: BlockType
        var element15: BlockType
        var element16: BlockType
        var element17: BlockType
        var element18: BlockType
        var element19: BlockType
        var element2: BlockType
        var element20: BlockType
        var element21: BlockType
        var element22: BlockType
        var element23: BlockType
        var element24: BlockType
        var element25: BlockType
        var element26: BlockType
        var element27: BlockType
        var element28: BlockType
        var element29: BlockType
        var element3: BlockType
        var element30: BlockType
        var element31: BlockType
        var element32: BlockType
        var element33: BlockType
        var element34: BlockType
        var element35: BlockType
        var element36: BlockType
        var element37: BlockType
        var element38: BlockType
        var element39: BlockType
        var element4: BlockType
        var element40: BlockType
        var element41: BlockType
        var element42: BlockType
        var element43: BlockType
        var element44: BlockType
        var element45: BlockType
        var element46: BlockType
        var element47: BlockType
        var element48: BlockType
        var element49: BlockType
        var element5: BlockType
        var element50: BlockType
        var element51: BlockType
        var element52: BlockType
        var element53: BlockType
        var element54: BlockType
        var element55: BlockType
        var element56: BlockType
        var element57: BlockType
        var element58: BlockType
        var element59: BlockType
        var element6: BlockType
        var element60: BlockType
        var element61: BlockType
        var element62: BlockType
        var element63: BlockType
        var element64: BlockType
        var element65: BlockType
        var element66: BlockType
        var element67: BlockType
        var element68: BlockType
        var element69: BlockType
        var element7: BlockType
        var element70: BlockType
        var element71: BlockType
        var element72: BlockType
        var element73: BlockType
        var element74: BlockType
        var element75: BlockType
        var element76: BlockType
        var element77: BlockType
        var element78: BlockType
        var element79: BlockType
        var element8: BlockType
        var element80: BlockType
        var element81: BlockType
        var element82: BlockType
        var element83: BlockType
        var element84: BlockType
        var element85: BlockType
        var element86: BlockType
        var element87: BlockType
        var element88: BlockType
        var element89: BlockType
        var element9: BlockType
        var element90: BlockType
        var element91: BlockType
        var element92: BlockType
        var element93: BlockType
        var element94: BlockType
        var element95: BlockType
        var element96: BlockType
        var element97: BlockType
        var element98: BlockType
        var element99: BlockType
        var emeraldBlock: BlockType
        var emeraldOre: BlockType
        var enchantingTable: BlockType
        var endBricks: BlockType
        var endBrickStairs: BlockType
        var enderChest: BlockType
        var endGateway: BlockType
        var endPortal: BlockType
        var endPortalFrame: BlockType
        var endRod: BlockType
        var endStone: BlockType
        var exposedCopper: BlockType
        var exposedCutCopper: BlockType
        var exposedCutCopperSlab: BlockType
        var exposedCutCopperStairs: BlockType
        var exposedDoubleCutCopperSlab: BlockType
        var farmland: BlockType
        var fence: BlockType
        var fenceGate: BlockType
        var fire: BlockType
        var fletchingTable: BlockType
        var floweringAzalea: BlockType
        var flowerPot: BlockType
        var flowingLava: BlockType
        var flowingWater: BlockType
        var frame: BlockType
        var frogSpawn: BlockType
        var frostedIce: BlockType
        var furnace: BlockType
        var gildedBlackstone: BlockType
        var glass: BlockType
        var glassPane: BlockType
        var glowFrame: BlockType
        var glowingobsidian: BlockType
        var glowLichen: BlockType
        var glowstone: BlockType
        var goldBlock: BlockType
        var goldenRail: BlockType
        var goldOre: BlockType
        var graniteStairs: BlockType
        var grass: BlockType
        var grassPath: BlockType
        var gravel: BlockType
        var grayCandle: BlockType
        var grayCandleCake: BlockType
        var grayGlazedTerracotta: BlockType
        var greenCandle: BlockType
        var greenCandleCake: BlockType
        var greenGlazedTerracotta: BlockType
        var grindstone: BlockType
        var hangingRoots: BlockType
        var hardenedClay: BlockType
        var hardGlass: BlockType
        var hardGlassPane: BlockType
        var hardStainedGlass: BlockType
        var hardStainedGlassPane: BlockType
        var hayBlock: BlockType
        var heavyWeightedPressurePlate: BlockType
        var honeyBlock: BlockType
        var honeycombBlock: BlockType
        var hopper: BlockType
        var ice: BlockType
        var infestedDeepslate: BlockType
        var infoUpdate: BlockType
        var infoUpdate2: BlockType
        var invisibleBedrock: BlockType
        var ironBars: BlockType
        var ironBlock: BlockType
        var ironDoor: BlockType
        var ironOre: BlockType
        var ironTrapdoor: BlockType
        var jigsaw: BlockType
        var jukebox: BlockType
        var jungleButton: BlockType
        var jungleDoor: BlockType
        var jungleFenceGate: BlockType
        var junglePressurePlate: BlockType
        var jungleStairs: BlockType
        var jungleStandingSign: BlockType
        var jungleTrapdoor: BlockType
        var jungleWallSign: BlockType
        var kelp: BlockType
        var ladder: BlockType
        var lantern: BlockType
        var lapisBlock: BlockType
        var lapisOre: BlockType
        var largeAmethystBud: BlockType
        var lava: BlockType
        var lavaCauldron: BlockType
        var leaves: BlockType
        var leaves2: BlockType
        var lectern: BlockType
        var lever: BlockType
        var lightBlock: BlockType
        var lightBlueCandle: BlockType
        var lightBlueCandleCake: BlockType
        var lightBlueGlazedTerracotta: BlockType
        var lightGrayCandle: BlockType
        var lightGrayCandleCake: BlockType
        var lightningRod: BlockType
        var lightWeightedPressurePlate: BlockType
        var limeCandle: BlockType
        var limeCandleCake: BlockType
        var limeGlazedTerracotta: BlockType
        var litBlastFurnace: BlockType
        var litDeepslateRedstoneOre: BlockType
        var litFurnace: BlockType
        var litPumpkin: BlockType
        var litRedstoneLamp: BlockType
        var litRedstoneOre: BlockType
        var litSmoker: BlockType
        var lodestone: BlockType
        var log: BlockType
        var log2: BlockType
        var loom: BlockType
        var magentaCandle: BlockType
        var magentaCandleCake: BlockType
        var magentaGlazedTerracotta: BlockType
        var magma: BlockType
        var mangroveButton: BlockType
        var mangroveDoor: BlockType
        var mangroveDoubleSlab: BlockType
        var mangroveFence: BlockType
        var mangroveFenceGate: BlockType
        var mangroveLeaves: BlockType
        var mangroveLog: BlockType
        var mangrovePlanks: BlockType
        var mangrovePressurePlate: BlockType
        var mangrovePropagule: BlockType
        var mangroveRoots: BlockType
        var mangroveSlab: BlockType
        var mangroveStairs: BlockType
        var mangroveStandingSign: BlockType
        var mangroveTrapdoor: BlockType
        var mangroveWallSign: BlockType
        var mangroveWood: BlockType
        var mediumAmethystBud: BlockType
        var melonBlock: BlockType
        var melonStem: BlockType
        var mobSpawner: BlockType
        var monsterEgg: BlockType
        var mossBlock: BlockType
        var mossCarpet: BlockType
        var mossyCobblestone: BlockType
        var mossyCobblestoneStairs: BlockType
        var mossyStoneBrickStairs: BlockType
        var movingBlock: BlockType
        var mud: BlockType
        var mudBrickDoubleSlab: BlockType
        var mudBricks: BlockType
        var mudBrickSlab: BlockType
        var mudBrickStairs: BlockType
        var mudBrickWall: BlockType
        var muddyMangroveRoots: BlockType
        var mycelium: BlockType
        var netherBrick: BlockType
        var netherBrickFence: BlockType
        var netherBrickStairs: BlockType
        var netherGoldOre: BlockType
        var netheriteBlock: BlockType
        var netherrack: BlockType
        var netherreactor: BlockType
        var netherSprouts: BlockType
        var netherWart: BlockType
        var netherWartBlock: BlockType
        var normalStoneStairs: BlockType
        var noteblock: BlockType
        var oakStairs: BlockType
        var observer: BlockType
        var obsidian: BlockType
        var ochreFroglight: BlockType
        var orangeCandle: BlockType
        var orangeCandleCake: BlockType
        var orangeGlazedTerracotta: BlockType
        var oxidizedCopper: BlockType
        var oxidizedCutCopper: BlockType
        var oxidizedCutCopperSlab: BlockType
        var oxidizedCutCopperStairs: BlockType
        var oxidizedDoubleCutCopperSlab: BlockType
        var packedIce: BlockType
        var packedMud: BlockType
        var pearlescentFroglight: BlockType
        var pinkCandle: BlockType
        var pinkCandleCake: BlockType
        var pinkGlazedTerracotta: BlockType
        var piston: BlockType
        var pistonArmCollision: BlockType
        var planks: BlockType
        var podzol: BlockType
        var pointedDripstone: BlockType
        var polishedAndesiteStairs: BlockType
        var polishedBasalt: BlockType
        var polishedBlackstone: BlockType
        var polishedBlackstoneBrickDoubleSlab: BlockType
        var polishedBlackstoneBricks: BlockType
        var polishedBlackstoneBrickSlab: BlockType
        var polishedBlackstoneBrickStairs: BlockType
        var polishedBlackstoneBrickWall: BlockType
        var polishedBlackstoneButton: BlockType
        var polishedBlackstoneDoubleSlab: BlockType
        var polishedBlackstonePressurePlate: BlockType
        var polishedBlackstoneSlab: BlockType
        var polishedBlackstoneStairs: BlockType
        var polishedBlackstoneWall: BlockType
        var polishedDeepslate: BlockType
        var polishedDeepslateDoubleSlab: BlockType
        var polishedDeepslateSlab: BlockType
        var polishedDeepslateStairs: BlockType
        var polishedDeepslateWall: BlockType
        var polishedDioriteStairs: BlockType
        var polishedGraniteStairs: BlockType
        var portal: BlockType
        var potatoes: BlockType
        var powderSnow: BlockType
        var poweredComparator: BlockType
        var poweredRepeater: BlockType
        var prismarine: BlockType
        var prismarineBricksStairs: BlockType
        var prismarineStairs: BlockType
        var pumpkin: BlockType
        var pumpkinStem: BlockType
        var purpleCandle: BlockType
        var purpleCandleCake: BlockType
        var purpleGlazedTerracotta: BlockType
        var purpurBlock: BlockType
        var purpurStairs: BlockType
        var quartzBlock: BlockType
        var quartzBricks: BlockType
        var quartzOre: BlockType
        var quartzStairs: BlockType
        var rail: BlockType
        var rawCopperBlock: BlockType
        var rawGoldBlock: BlockType
        var rawIronBlock: BlockType
        var redCandle: BlockType
        var redCandleCake: BlockType
        var redFlower: BlockType
        var redGlazedTerracotta: BlockType
        var redMushroom: BlockType
        var redMushroomBlock: BlockType
        var redNetherBrick: BlockType
        var redNetherBrickStairs: BlockType
        var redSandstone: BlockType
        var redSandstoneStairs: BlockType
        var redstoneBlock: BlockType
        var redstoneLamp: BlockType
        var redstoneOre: BlockType
        var redstoneTorch: BlockType
        var redstoneWire: BlockType
        var reeds: BlockType
        var reinforcedDeepslate: BlockType
        var repeatingCommandBlock: BlockType
        var reserved6: BlockType
        var respawnAnchor: BlockType
        var sand: BlockType
        var sandstone: BlockType
        var sandstoneStairs: BlockType
        var sapling: BlockType
        var scaffolding: BlockType
        var sculk: BlockType
        var sculkCatalyst: BlockType
        var sculkSensor: BlockType
        var sculkShrieker: BlockType
        var sculkVein: BlockType
        var seagrass: BlockType
        var seaLantern: BlockType
        var seaPickle: BlockType
        var shroomlight: BlockType
        var shulkerBox: BlockType
        var silverGlazedTerracotta: BlockType
        var skull: BlockType
        var slime: BlockType
        var smallAmethystBud: BlockType
        var smallDripleafBlock: BlockType
        var smithingTable: BlockType
        var smoker: BlockType
        var smoothBasalt: BlockType
        var smoothQuartzStairs: BlockType
        var smoothRedSandstoneStairs: BlockType
        var smoothSandstoneStairs: BlockType
        var smoothStone: BlockType
        var snow: BlockType
        var snowLayer: BlockType
        var soulCampfire: BlockType
        var soulFire: BlockType
        var soulLantern: BlockType
        var soulSand: BlockType
        var soulSoil: BlockType
        var soulTorch: BlockType
        var sponge: BlockType
        var sporeBlossom: BlockType
        var spruceButton: BlockType
        var spruceDoor: BlockType
        var spruceFenceGate: BlockType
        var sprucePressurePlate: BlockType
        var spruceStairs: BlockType
        var spruceStandingSign: BlockType
        var spruceTrapdoor: BlockType
        var spruceWallSign: BlockType
        var stainedGlass: BlockType
        var stainedGlassPane: BlockType
        var stainedHardenedClay: BlockType
        var standingBanner: BlockType
        var standingSign: BlockType
        var stickyPiston: BlockType
        var stickyPistonArmCollision: BlockType
        var stone: BlockType
        var stoneBlockSlab: BlockType
        var stoneBlockSlab2: BlockType
        var stoneBlockSlab3: BlockType
        var stoneBlockSlab4: BlockType
        var stonebrick: BlockType
        var stoneBrickStairs: BlockType
        var stoneButton: BlockType
        var stonecutter: BlockType
        var stonecutterBlock: BlockType
        var stonePressurePlate: BlockType
        var stoneSlab: BlockType
        var stoneSlab2: BlockType
        var stoneSlab3: BlockType
        var stoneSlab4: BlockType
        var stoneStairs: BlockType
        var strippedAcaciaLog: BlockType
        var strippedBirchLog: BlockType
        var strippedCrimsonHyphae: BlockType
        var strippedCrimsonStem: BlockType
        var strippedDarkOakLog: BlockType
        var strippedJungleLog: BlockType
        var strippedMangroveLog: BlockType
        var strippedMangroveWood: BlockType
        var strippedOakLog: BlockType
        var strippedSpruceLog: BlockType
        var strippedWarpedHyphae: BlockType
        var strippedWarpedStem: BlockType
        var structureBlock: BlockType
        var structureVoid: BlockType
        var sweetBerryBush: BlockType
        var tallgrass: BlockType
        var target: BlockType
        var tintedGlass: BlockType
        var tnt: BlockType
        var torch: BlockType
        var trapdoor: BlockType
        var trappedChest: BlockType
        var tripWire: BlockType
        var tripwireHook: BlockType
        var tuff: BlockType
        var turtleEgg: BlockType
        var twistingVines: BlockType
        var underwaterTorch: BlockType
        var undyedShulkerBox: BlockType
        var unknown: BlockType
        var unlitRedstoneTorch: BlockType
        var unpoweredComparator: BlockType
        var unpoweredRepeater: BlockType
        var verdantFroglight: BlockType
        var vine: BlockType
        var wallBanner: BlockType
        var wallSign: BlockType
        var warpedButton: BlockType
        var warpedDoor: BlockType
        var warpedDoubleSlab: BlockType
        var warpedFence: BlockType
        var warpedFenceGate: BlockType
        var warpedFungus: BlockType
        var warpedHyphae: BlockType
        var warpedNylium: BlockType
        var warpedPlanks: BlockType
        var warpedPressurePlate: BlockType
        var warpedRoots: BlockType
        var warpedSlab: BlockType
        var warpedStairs: BlockType
        var warpedStandingSign: BlockType
        var warpedStem: BlockType
        var warpedTrapdoor: BlockType
        var warpedWallSign: BlockType
        var warpedWartBlock: BlockType
        var water: BlockType
        var waterlily: BlockType
        var waxedCopper: BlockType
        var waxedCutCopper: BlockType
        var waxedCutCopperSlab: BlockType
        var waxedCutCopperStairs: BlockType
        var waxedDoubleCutCopperSlab: BlockType
        var waxedExposedCopper: BlockType
        var waxedExposedCutCopper: BlockType
        var waxedExposedCutCopperSlab: BlockType
        var waxedExposedCutCopperStairs: BlockType
        var waxedExposedDoubleCutCopperSlab: BlockType
        var waxedOxidizedCopper: BlockType
        var waxedOxidizedCutCopper: BlockType
        var waxedOxidizedCutCopperSlab: BlockType
        var waxedOxidizedCutCopperStairs: BlockType
        var waxedOxidizedDoubleCutCopperSlab: BlockType
        var waxedWeatheredCopper: BlockType
        var waxedWeatheredCutCopper: BlockType
        var waxedWeatheredCutCopperSlab: BlockType
        var waxedWeatheredCutCopperStairs: BlockType
        var waxedWeatheredDoubleCutCopperSlab: BlockType
        var weatheredCopper: BlockType
        var weatheredCutCopper: BlockType
        var weatheredCutCopperSlab: BlockType
        var weatheredCutCopperStairs: BlockType
        var weatheredDoubleCutCopperSlab: BlockType
        var web: BlockType
        var weepingVines: BlockType
        var wheat: BlockType
        var whiteCandle: BlockType
        var whiteCandleCake: BlockType
        var whiteGlazedTerracotta: BlockType
        var witherRose: BlockType
        var wood: BlockType
        var woodenButton: BlockType
        var woodenDoor: BlockType
        var woodenPressurePlate: BlockType
        var woodenSlab: BlockType
        var wool: BlockType
        var yellowCandle: BlockType
        var yellowCandleCake: BlockType
        var yellowFlower: BlockType
        var yellowGlazedTerracotta: BlockType
        fun get(typeName: String): BlockType
        fun getAllBlockTypes(): Array<BlockType>
    }
}

external open class MinecraftDimensionTypes {
    companion object {
        var nether: String = definedExternally
        var overworld: String = definedExternally
        var theEnd: String = definedExternally
    }
}

external open class MinecraftEffectTypes {
    companion object {
        var absorption: EffectType
        var badOmen: EffectType
        var blindness: EffectType
        var conduitPower: EffectType
        var darkness: EffectType
        var empty: EffectType
        var fatalPoison: EffectType
        var fireResistance: EffectType
        var haste: EffectType
        var healthBoost: EffectType
        var hunger: EffectType
        var instantDamage: EffectType
        var instantHealth: EffectType
        var invisibility: EffectType
        var jumpBoost: EffectType
        var levitation: EffectType
        var miningFatigue: EffectType
        var nausea: EffectType
        var nightVision: EffectType
        var poison: EffectType
        var regeneration: EffectType
        var resistance: EffectType
        var saturation: EffectType
        var slowFalling: EffectType
        var slowness: EffectType
        var speed: EffectType
        var strength: EffectType
        var villageHero: EffectType
        var waterBreathing: EffectType
        var weakness: EffectType
        var wither: EffectType
    }
}

external open class MinecraftEnchantmentTypes {
    companion object {
        var aquaAffinity: EnchantmentType
        var baneOfArthropods: EnchantmentType
        var binding: EnchantmentType
        var blastProtection: EnchantmentType
        var channeling: EnchantmentType
        var depthStrider: EnchantmentType
        var efficiency: EnchantmentType
        var featherFalling: EnchantmentType
        var fireAspect: EnchantmentType
        var fireProtection: EnchantmentType
        var flame: EnchantmentType
        var fortune: EnchantmentType
        var frostWalker: EnchantmentType
        var impaling: EnchantmentType
        var infinity: EnchantmentType
        var knockback: EnchantmentType
        var looting: EnchantmentType
        var loyalty: EnchantmentType
        var luckOfTheSea: EnchantmentType
        var lure: EnchantmentType
        var mending: EnchantmentType
        var multishot: EnchantmentType
        var piercing: EnchantmentType
        var power: EnchantmentType
        var projectileProtection: EnchantmentType
        var protection: EnchantmentType
        var punch: EnchantmentType
        var quickCharge: EnchantmentType
        var respiration: EnchantmentType
        var riptide: EnchantmentType
        var sharpness: EnchantmentType
        var silkTouch: EnchantmentType
        var smite: EnchantmentType
        var soulSpeed: EnchantmentType
        var swiftSneak: EnchantmentType
        var thorns: EnchantmentType
        var unbreaking: EnchantmentType
        var vanishing: EnchantmentType
    }
}

external open class MinecraftEntityTypes {
    companion object {
        var agent: EntityType
        var allay: EntityType
        var areaEffectCloud: EntityType
        var armorStand: EntityType
        var arrow: EntityType
        var axolotl: EntityType
        var bat: EntityType
        var bee: EntityType
        var blaze: EntityType
        var boat: EntityType
        var cat: EntityType
        var caveSpider: EntityType
        var chestBoat: EntityType
        var chestMinecart: EntityType
        var chicken: EntityType
        var cod: EntityType
        var commandBlockMinecart: EntityType
        var cow: EntityType
        var creeper: EntityType
        var dolphin: EntityType
        var donkey: EntityType
        var dragonFireball: EntityType
        var drowned: EntityType
        var egg: EntityType
        var elderGuardian: EntityType
        var enderCrystal: EntityType
        var enderDragon: EntityType
        var enderman: EntityType
        var endermite: EntityType
        var enderPearl: EntityType
        var evocationIllager: EntityType
        var eyeOfEnderSignal: EntityType
        var fireball: EntityType
        var fireworksRocket: EntityType
        var fishingHook: EntityType
        var fox: EntityType
        var frog: EntityType
        var ghast: EntityType
        var glowSquid: EntityType
        var goat: EntityType
        var guardian: EntityType
        var hoglin: EntityType
        var hopperMinecart: EntityType
        var horse: EntityType
        var husk: EntityType
        var ironGolem: EntityType
        var lightningBolt: EntityType
        var lingeringPotion: EntityType
        var llama: EntityType
        var llamaSpit: EntityType
        var magmaCube: EntityType
        var minecart: EntityType
        var mooshroom: EntityType
        var mule: EntityType
        var npc: EntityType
        var ocelot: EntityType
        var panda: EntityType
        var parrot: EntityType
        var phantom: EntityType
        var pig: EntityType
        var piglin: EntityType
        var piglinBrute: EntityType
        var pillager: EntityType
        var player: EntityType
        var polarBear: EntityType
        var pufferfish: EntityType
        var rabbit: EntityType
        var ravager: EntityType
        var salmon: EntityType
        var sheep: EntityType
        var shulker: EntityType
        var shulkerBullet: EntityType
        var silverfish: EntityType
        var skeleton: EntityType
        var skeletonHorse: EntityType
        var slime: EntityType
        var smallFireball: EntityType
        var snowball: EntityType
        var snowGolem: EntityType
        var spider: EntityType
        var splashPotion: EntityType
        var squid: EntityType
        var stray: EntityType
        var strider: EntityType
        var tadpole: EntityType
        var thrownTrident: EntityType
        var tnt: EntityType
        var tntMinecart: EntityType
        var tripodCamera: EntityType
        var tropicalfish: EntityType
        var turtle: EntityType
        var vex: EntityType
        var villager: EntityType
        var villagerV2: EntityType
        var vindicator: EntityType
        var wanderingTrader: EntityType
        var warden: EntityType
        var witch: EntityType
        var wither: EntityType
        var witherSkeleton: EntityType
        var witherSkull: EntityType
        var witherSkullDangerous: EntityType
        var wolf: EntityType
        var xpBottle: EntityType
        var xpOrb: EntityType
        var zoglin: EntityType
        var zombie: EntityType
        var zombieHorse: EntityType
        var zombiePigman: EntityType
        var zombieVillager: EntityType
        var zombieVillagerV2: EntityType
    }
}

var MinecraftItemTypes.Companion.itemAcadiaDoor: ItemType
    get() = asDynamic()["item.acaciaDoor"] as ItemType
    set(value) {
        asDynamic()["item.acaciaDoor"] = value
    }

var MinecraftItemTypes.Companion.itemBed: ItemType
    get() = asDynamic()["item.bed"] as ItemType
    set(value) {
        asDynamic()["item.bed"] = value
    }

var MinecraftItemTypes.Companion.itemBeetroot: ItemType
    get() = asDynamic()["item.beetroot"] as ItemType
    set(value) {
        asDynamic()["item.beetroot"] = value
    }

var MinecraftItemTypes.Companion.itemBirchDoor: ItemType
    get() = asDynamic()["item.birchDoor"] as ItemType
    set(value) {
        asDynamic()["item.birchDoor"] = value
    }

var MinecraftItemTypes.Companion.itemBrewingStand: ItemType
    get() = asDynamic()["item.brewingStand"] as ItemType
    set(value) {
        asDynamic()["item.brewingStand"] = value
    }

var MinecraftItemTypes.Companion.itemCake: ItemType
    get() = asDynamic()["item.cake"] as ItemType
    set(value) {
        asDynamic()["item.cake"] = value
    }

var MinecraftItemTypes.Companion.itemCamera: ItemType
    get() = asDynamic()["item.camera"] as ItemType
    set(value) {
        asDynamic()["item.camera"] = value
    }

var MinecraftItemTypes.Companion.itemCampfire: ItemType
    get() = asDynamic()["item.campfire"] as ItemType
    set(value) {
        asDynamic()["item.campfire"] = value
    }

var MinecraftItemTypes.Companion.itemCauldron: ItemType
    get() = asDynamic()["item.cauldron"] as ItemType
    set(value) {
        asDynamic()["item.cauldron"] = value
    }

var MinecraftItemTypes.Companion.itemChain: ItemType
    get() = asDynamic()["item.chain"] as ItemType
    set(value) {
        asDynamic()["item.chain"] = value
    }

var MinecraftItemTypes.Companion.itemCrimsonDoor: ItemType
    get() = asDynamic()["item.crimsonDoor"] as ItemType
    set(value) {
        asDynamic()["item.crimsonDoor"] = value
    }

var MinecraftItemTypes.Companion.itemDarkOakDoor: ItemType
    get() = asDynamic()["item.darkOakDoor"] as ItemType
    set(value) {
        asDynamic()["item.darkOakDoor"] = value
    }

var MinecraftItemTypes.Companion.itemFlowerPot: ItemType
    get() = asDynamic()["item.flowerPot"] as ItemType
    set(value) {
        asDynamic()["item.flowerPot"] = value
    }

var MinecraftItemTypes.Companion.itemFrame: ItemType
    get() = asDynamic()["item.frame"] as ItemType
    set(value) {
        asDynamic()["item.frame"] = value
    }

var MinecraftItemTypes.Companion.itemGlowFrame: ItemType
    get() = asDynamic()["item.glowFrame"] as ItemType
    set(value) {
        asDynamic()["item.glowFrame"] = value
    }

var MinecraftItemTypes.Companion.itemHopper: ItemType
    get() = asDynamic()["item.hopper"] as ItemType
    set(value) {
        asDynamic()["item.hopper"] = value
    }

var MinecraftItemTypes.Companion.itemIronDoor: ItemType
    get() = asDynamic()["item.ironDoor"] as ItemType
    set(value) {
        asDynamic()["item.ironDoor"] = value
    }

var MinecraftItemTypes.Companion.itemJungleDoor: ItemType
    get() = asDynamic()["item.jungleDoor"] as ItemType
    set(value) {
        asDynamic()["item.jungleDoor"] = value
    }

var MinecraftItemTypes.Companion.itemKelp: ItemType
    get() = asDynamic()["item.kelp"] as ItemType
    set(value) {
        asDynamic()["item.kelp"] = value
    }

var MinecraftItemTypes.Companion.itemMangroveDoor: ItemType
    get() = asDynamic()["item.mangroveDoor"] as ItemType
    set(value) {
        asDynamic()["item.mangroveDoor"] = value
    }

var MinecraftItemTypes.Companion.itemNetherSprouts: ItemType
    get() = asDynamic()["item.netherSprouts"] as ItemType
    set(value) {
        asDynamic()["item.netherSprouts"] = value
    }

var MinecraftItemTypes.Companion.itemNetherWart: ItemType
    get() = asDynamic()["item.netherWart"] as ItemType
    set(value) {
        asDynamic()["item.netherWart"] = value
    }

var MinecraftItemTypes.Companion.itemReeds: ItemType
    get() = asDynamic()["item.reeds"] as ItemType
    set(value) {
        asDynamic()["item.reeds"] = value
    }

var MinecraftItemTypes.Companion.itemSkull: ItemType
    get() = asDynamic()["item.skull"] as ItemType
    set(value) {
        asDynamic()["item.skull"] = value
    }

var MinecraftItemTypes.Companion.itemSoulCampfire: ItemType
    get() = asDynamic()["item.soulCampfire"] as ItemType
    set(value) {
        asDynamic()["item.soulCampfire"] = value
    }

var MinecraftItemTypes.Companion.itemSpruceDoor: ItemType
    get() = asDynamic()["item.spruceDoor"] as ItemType
    set(value) {
        asDynamic()["item.spruceDoor"] = value
    }

var MinecraftItemTypes.Companion.itemWarpedDoor: ItemType
    get() = asDynamic()["item.warpedDoor"] as ItemType
    set(value) {
        asDynamic()["item.warpedDoor"] = value
    }

var MinecraftItemTypes.Companion.itemWheat: ItemType
    get() = asDynamic()["item.wheat"] as ItemType
    set(value) {
        asDynamic()["item.wheat"] = value
    }

var MinecraftItemTypes.Companion.itemWoodenDoor: ItemType
    get() = asDynamic()["item.woodenDoor"] as ItemType
    set(value) {
        asDynamic()["item.woodenDoor"] = value
    }

external open class MinecraftItemTypes {
    companion object {
        var acaciaBoat: ItemType
        var acaciaButton: ItemType
        var acaciaChestBoat: ItemType
        var acaciaDoor: ItemType
        var acaciaFenceGate: ItemType
        var acaciaPressurePlate: ItemType
        var acaciaSign: ItemType
        var acaciaStairs: ItemType
        var acaciaStandingSign: ItemType
        var acaciaTrapdoor: ItemType
        var acaciaWallSign: ItemType
        var activatorRail: ItemType
        var agentSpawnEgg: ItemType
        var air: ItemType
        var allaySpawnEgg: ItemType
        var allow: ItemType
        var amethystBlock: ItemType
        var amethystCluster: ItemType
        var amethystShard: ItemType
        var ancientDebris: ItemType
        var andesiteStairs: ItemType
        var anvil: ItemType
        var apple: ItemType
        var armorStand: ItemType
        var arrow: ItemType
        var axolotlBucket: ItemType
        var axolotlSpawnEgg: ItemType
        var azalea: ItemType
        var azaleaLeaves: ItemType
        var azaleaLeavesFlowered: ItemType
        var bakedPotato: ItemType
        var balloon: ItemType
        var bamboo: ItemType
        var bambooSapling: ItemType
        var banner: ItemType
        var bannerPattern: ItemType
        var barrel: ItemType
        var barrier: ItemType
        var basalt: ItemType
        var batSpawnEgg: ItemType
        var beacon: ItemType
        var bed: ItemType
        var bedrock: ItemType
        var beef: ItemType
        var beehive: ItemType
        var beeNest: ItemType
        var beeSpawnEgg: ItemType
        var beetroot: ItemType
        var beetrootSeeds: ItemType
        var beetrootSoup: ItemType
        var bell: ItemType
        var bigDripleaf: ItemType
        var birchBoat: ItemType
        var birchButton: ItemType
        var birchChestBoat: ItemType
        var birchDoor: ItemType
        var birchFenceGate: ItemType
        var birchPressurePlate: ItemType
        var birchSign: ItemType
        var birchStairs: ItemType
        var birchStandingSign: ItemType
        var birchTrapdoor: ItemType
        var birchWallSign: ItemType
        var blackCandle: ItemType
        var blackCandleCake: ItemType
        var blackDye: ItemType
        var blackGlazedTerracotta: ItemType
        var blackstone: ItemType
        var blackstoneDoubleSlab: ItemType
        var blackstoneSlab: ItemType
        var blackstoneStairs: ItemType
        var blackstoneWall: ItemType
        var blastFurnace: ItemType
        var blazePowder: ItemType
        var blazeRod: ItemType
        var blazeSpawnEgg: ItemType
        var bleach: ItemType
        var blueCandle: ItemType
        var blueCandleCake: ItemType
        var blueDye: ItemType
        var blueGlazedTerracotta: ItemType
        var blueIce: ItemType
        var boat: ItemType
        var bone: ItemType
        var boneBlock: ItemType
        var boneMeal: ItemType
        var book: ItemType
        var bookshelf: ItemType
        var borderBlock: ItemType
        var bordureIndentedBannerPattern: ItemType
        var bow: ItemType
        var bowl: ItemType
        var bread: ItemType
        var brewingStand: ItemType
        var brick: ItemType
        var brickBlock: ItemType
        var brickStairs: ItemType
        var brownCandle: ItemType
        var brownCandleCake: ItemType
        var brownDye: ItemType
        var brownGlazedTerracotta: ItemType
        var brownMushroom: ItemType
        var brownMushroomBlock: ItemType
        var bubbleColumn: ItemType
        var bucket: ItemType
        var buddingAmethyst: ItemType
        var cactus: ItemType
        var cake: ItemType
        var calcite: ItemType
        var camera: ItemType
        var campfire: ItemType
        var candle: ItemType
        var candleCake: ItemType
        var carpet: ItemType
        var carrot: ItemType
        var carrotOnAStick: ItemType
        var carrots: ItemType
        var cartographyTable: ItemType
        var carvedPumpkin: ItemType
        var catSpawnEgg: ItemType
        var cauldron: ItemType
        var caveSpiderSpawnEgg: ItemType
        var caveVines: ItemType
        var caveVinesBodyWithBerries: ItemType
        var caveVinesHeadWithBerries: ItemType
        var chain: ItemType
        var chainCommandBlock: ItemType
        var chainmailBoots: ItemType
        var chainmailChestplate: ItemType
        var chainmailHelmet: ItemType
        var chainmailLeggings: ItemType
        var charcoal: ItemType
        var chemicalHeat: ItemType
        var chemistryTable: ItemType
        var chest: ItemType
        var chestBoat: ItemType
        var chestMinecart: ItemType
        var chicken: ItemType
        var chickenSpawnEgg: ItemType
        var chiseledDeepslate: ItemType
        var chiseledNetherBricks: ItemType
        var chiseledPolishedBlackstone: ItemType
        var chorusFlower: ItemType
        var chorusFruit: ItemType
        var chorusPlant: ItemType
        var clay: ItemType
        var clayBall: ItemType
        var clientRequestPlaceholderBlock: ItemType
        var clock: ItemType
        var coal: ItemType
        var coalBlock: ItemType
        var coalOre: ItemType
        var cobbledDeepslate: ItemType
        var cobbledDeepslateDoubleSlab: ItemType
        var cobbledDeepslateSlab: ItemType
        var cobbledDeepslateStairs: ItemType
        var cobbledDeepslateWall: ItemType
        var cobblestone: ItemType
        var cobblestoneWall: ItemType
        var cocoa: ItemType
        var cocoaBeans: ItemType
        var cod: ItemType
        var codBucket: ItemType
        var codSpawnEgg: ItemType
        var coloredTorchBp: ItemType
        var coloredTorchRg: ItemType
        var commandBlock: ItemType
        var commandBlockMinecart: ItemType
        var comparator: ItemType
        var compass: ItemType
        var composter: ItemType
        var compound: ItemType
        var concrete: ItemType
        var concretePowder: ItemType
        var conduit: ItemType
        var cookedBeef: ItemType
        var cookedChicken: ItemType
        var cookedCod: ItemType
        var cookedMutton: ItemType
        var cookedPorkchop: ItemType
        var cookedRabbit: ItemType
        var cookedSalmon: ItemType
        var cookie: ItemType
        var copperBlock: ItemType
        var copperIngot: ItemType
        var copperOre: ItemType
        var coral: ItemType
        var coralBlock: ItemType
        var coralFan: ItemType
        var coralFanDead: ItemType
        var coralFanHang: ItemType
        var coralFanHang2: ItemType
        var coralFanHang3: ItemType
        var cowSpawnEgg: ItemType
        var crackedDeepslateBricks: ItemType
        var crackedDeepslateTiles: ItemType
        var crackedNetherBricks: ItemType
        var crackedPolishedBlackstoneBricks: ItemType
        var craftingTable: ItemType
        var creeperBannerPattern: ItemType
        var creeperSpawnEgg: ItemType
        var crimsonButton: ItemType
        var crimsonDoor: ItemType
        var crimsonDoubleSlab: ItemType
        var crimsonFence: ItemType
        var crimsonFenceGate: ItemType
        var crimsonFungus: ItemType
        var crimsonHyphae: ItemType
        var crimsonNylium: ItemType
        var crimsonPlanks: ItemType
        var crimsonPressurePlate: ItemType
        var crimsonRoots: ItemType
        var crimsonSign: ItemType
        var crimsonSlab: ItemType
        var crimsonStairs: ItemType
        var crimsonStandingSign: ItemType
        var crimsonStem: ItemType
        var crimsonTrapdoor: ItemType
        var crimsonWallSign: ItemType
        var crossbow: ItemType
        var cryingObsidian: ItemType
        var cutCopper: ItemType
        var cutCopperSlab: ItemType
        var cutCopperStairs: ItemType
        var cyanCandle: ItemType
        var cyanCandleCake: ItemType
        var cyanDye: ItemType
        var cyanGlazedTerracotta: ItemType
        var darkOakBoat: ItemType
        var darkOakButton: ItemType
        var darkOakChestBoat: ItemType
        var darkOakDoor: ItemType
        var darkOakFenceGate: ItemType
        var darkOakPressurePlate: ItemType
        var darkOakSign: ItemType
        var darkOakStairs: ItemType
        var darkoakStandingSign: ItemType
        var darkOakTrapdoor: ItemType
        var darkoakWallSign: ItemType
        var darkPrismarineStairs: ItemType
        var daylightDetector: ItemType
        var daylightDetectorInverted: ItemType
        var deadbush: ItemType
        var debugStick: ItemType
        var deepslate: ItemType
        var deepslateBrickDoubleSlab: ItemType
        var deepslateBricks: ItemType
        var deepslateBrickSlab: ItemType
        var deepslateBrickStairs: ItemType
        var deepslateBrickWall: ItemType
        var deepslateCoalOre: ItemType
        var deepslateCopperOre: ItemType
        var deepslateDiamondOre: ItemType
        var deepslateEmeraldOre: ItemType
        var deepslateGoldOre: ItemType
        var deepslateIronOre: ItemType
        var deepslateLapisOre: ItemType
        var deepslateRedstoneOre: ItemType
        var deepslateTileDoubleSlab: ItemType
        var deepslateTiles: ItemType
        var deepslateTileSlab: ItemType
        var deepslateTileStairs: ItemType
        var deepslateTileWall: ItemType
        var deny: ItemType
        var detectorRail: ItemType
        var diamond: ItemType
        var diamondAxe: ItemType
        var diamondBlock: ItemType
        var diamondBoots: ItemType
        var diamondChestplate: ItemType
        var diamondHelmet: ItemType
        var diamondHoe: ItemType
        var diamondHorseArmor: ItemType
        var diamondLeggings: ItemType
        var diamondOre: ItemType
        var diamondPickaxe: ItemType
        var diamondShovel: ItemType
        var diamondSword: ItemType
        var dioriteStairs: ItemType
        var dirt: ItemType
        var dirtWithRoots: ItemType
        var discFragment5: ItemType
        var dispenser: ItemType
        var dolphinSpawnEgg: ItemType
        var donkeySpawnEgg: ItemType
        var doubleCutCopperSlab: ItemType
        var doublePlant: ItemType
        var doubleStoneBlockSlab: ItemType
        var doubleStoneBlockSlab2: ItemType
        var doubleStoneBlockSlab3: ItemType
        var doubleStoneBlockSlab4: ItemType
        var doubleWoodenSlab: ItemType
        var dragonBreath: ItemType
        var dragonEgg: ItemType
        var driedKelp: ItemType
        var driedKelpBlock: ItemType
        var dripstoneBlock: ItemType
        var dropper: ItemType
        var drownedSpawnEgg: ItemType
        var dye: ItemType
        var echoShard: ItemType
        var egg: ItemType
        var elderGuardianSpawnEgg: ItemType
        var element0: ItemType
        var element1: ItemType
        var element10: ItemType
        var element100: ItemType
        var element101: ItemType
        var element102: ItemType
        var element103: ItemType
        var element104: ItemType
        var element105: ItemType
        var element106: ItemType
        var element107: ItemType
        var element108: ItemType
        var element109: ItemType
        var element11: ItemType
        var element110: ItemType
        var element111: ItemType
        var element112: ItemType
        var element113: ItemType
        var element114: ItemType
        var element115: ItemType
        var element116: ItemType
        var element117: ItemType
        var element118: ItemType
        var element12: ItemType
        var element13: ItemType
        var element14: ItemType
        var element15: ItemType
        var element16: ItemType
        var element17: ItemType
        var element18: ItemType
        var element19: ItemType
        var element2: ItemType
        var element20: ItemType
        var element21: ItemType
        var element22: ItemType
        var element23: ItemType
        var element24: ItemType
        var element25: ItemType
        var element26: ItemType
        var element27: ItemType
        var element28: ItemType
        var element29: ItemType
        var element3: ItemType
        var element30: ItemType
        var element31: ItemType
        var element32: ItemType
        var element33: ItemType
        var element34: ItemType
        var element35: ItemType
        var element36: ItemType
        var element37: ItemType
        var element38: ItemType
        var element39: ItemType
        var element4: ItemType
        var element40: ItemType
        var element41: ItemType
        var element42: ItemType
        var element43: ItemType
        var element44: ItemType
        var element45: ItemType
        var element46: ItemType
        var element47: ItemType
        var element48: ItemType
        var element49: ItemType
        var element5: ItemType
        var element50: ItemType
        var element51: ItemType
        var element52: ItemType
        var element53: ItemType
        var element54: ItemType
        var element55: ItemType
        var element56: ItemType
        var element57: ItemType
        var element58: ItemType
        var element59: ItemType
        var element6: ItemType
        var element60: ItemType
        var element61: ItemType
        var element62: ItemType
        var element63: ItemType
        var element64: ItemType
        var element65: ItemType
        var element66: ItemType
        var element67: ItemType
        var element68: ItemType
        var element69: ItemType
        var element7: ItemType
        var element70: ItemType
        var element71: ItemType
        var element72: ItemType
        var element73: ItemType
        var element74: ItemType
        var element75: ItemType
        var element76: ItemType
        var element77: ItemType
        var element78: ItemType
        var element79: ItemType
        var element8: ItemType
        var element80: ItemType
        var element81: ItemType
        var element82: ItemType
        var element83: ItemType
        var element84: ItemType
        var element85: ItemType
        var element86: ItemType
        var element87: ItemType
        var element88: ItemType
        var element89: ItemType
        var element9: ItemType
        var element90: ItemType
        var element91: ItemType
        var element92: ItemType
        var element93: ItemType
        var element94: ItemType
        var element95: ItemType
        var element96: ItemType
        var element97: ItemType
        var element98: ItemType
        var element99: ItemType
        var elytra: ItemType
        var emerald: ItemType
        var emeraldBlock: ItemType
        var emeraldOre: ItemType
        var emptyMap: ItemType
        var enchantedBook: ItemType
        var enchantedGoldenApple: ItemType
        var enchantingTable: ItemType
        var endBricks: ItemType
        var endBrickStairs: ItemType
        var endCrystal: ItemType
        var enderChest: ItemType
        var enderEye: ItemType
        var endermanSpawnEgg: ItemType
        var endermiteSpawnEgg: ItemType
        var enderPearl: ItemType
        var endGateway: ItemType
        var endPortal: ItemType
        var endPortalFrame: ItemType
        var endRod: ItemType
        var endStone: ItemType
        var evokerSpawnEgg: ItemType
        var experienceBottle: ItemType
        var exposedCopper: ItemType
        var exposedCutCopper: ItemType
        var exposedCutCopperSlab: ItemType
        var exposedCutCopperStairs: ItemType
        var exposedDoubleCutCopperSlab: ItemType
        var farmland: ItemType
        var feather: ItemType
        var fence: ItemType
        var fenceGate: ItemType
        var fermentedSpiderEye: ItemType
        var fieldMasonedBannerPattern: ItemType
        var filledMap: ItemType
        var fire: ItemType
        var fireCharge: ItemType
        var fireflySpawnEgg: ItemType
        var fireworkRocket: ItemType
        var fireworkStar: ItemType
        var fishingRod: ItemType
        var fletchingTable: ItemType
        var flint: ItemType
        var flintAndSteel: ItemType
        var flowerBannerPattern: ItemType
        var floweringAzalea: ItemType
        var flowerPot: ItemType
        var flowingLava: ItemType
        var flowingWater: ItemType
        var foxSpawnEgg: ItemType
        var frame: ItemType
        var frogSpawn: ItemType
        var frogSpawnEgg: ItemType
        var frostedIce: ItemType
        var furnace: ItemType
        var ghastSpawnEgg: ItemType
        var ghastTear: ItemType
        var gildedBlackstone: ItemType
        var glass: ItemType
        var glassBottle: ItemType
        var glassPane: ItemType
        var glisteringMelonSlice: ItemType
        var globeBannerPattern: ItemType
        var glowBerries: ItemType
        var glowFrame: ItemType
        var glowingobsidian: ItemType
        var glowInkSac: ItemType
        var glowLichen: ItemType
        var glowSquidSpawnEgg: ItemType
        var glowStick: ItemType
        var glowstone: ItemType
        var glowstoneDust: ItemType
        var goatHorn: ItemType
        var goatSpawnEgg: ItemType
        var goldBlock: ItemType
        var goldenApple: ItemType
        var goldenAxe: ItemType
        var goldenBoots: ItemType
        var goldenCarrot: ItemType
        var goldenChestplate: ItemType
        var goldenHelmet: ItemType
        var goldenHoe: ItemType
        var goldenHorseArmor: ItemType
        var goldenLeggings: ItemType
        var goldenPickaxe: ItemType
        var goldenRail: ItemType
        var goldenShovel: ItemType
        var goldenSword: ItemType
        var goldIngot: ItemType
        var goldNugget: ItemType
        var goldOre: ItemType
        var graniteStairs: ItemType
        var grass: ItemType
        var grassPath: ItemType
        var gravel: ItemType
        var grayCandle: ItemType
        var grayCandleCake: ItemType
        var grayDye: ItemType
        var grayGlazedTerracotta: ItemType
        var greenCandle: ItemType
        var greenCandleCake: ItemType
        var greenDye: ItemType
        var greenGlazedTerracotta: ItemType
        var grindstone: ItemType
        var guardianSpawnEgg: ItemType
        var gunpowder: ItemType
        var hangingRoots: ItemType
        var hardenedClay: ItemType
        var hardGlass: ItemType
        var hardGlassPane: ItemType
        var hardStainedGlass: ItemType
        var hardStainedGlassPane: ItemType
        var hayBlock: ItemType
        var heartOfTheSea: ItemType
        var heavyWeightedPressurePlate: ItemType
        var hoglinSpawnEgg: ItemType
        var honeyBlock: ItemType
        var honeyBottle: ItemType
        var honeycomb: ItemType
        var honeycombBlock: ItemType
        var hopper: ItemType
        var hopperMinecart: ItemType
        var horseSpawnEgg: ItemType
        var huskSpawnEgg: ItemType
        var ice: ItemType
        var iceBomb: ItemType
        var infestedDeepslate: ItemType
        var infoUpdate: ItemType
        var infoUpdate2: ItemType
        var inkSac: ItemType
        var invisibleBedrock: ItemType
        var ironAxe: ItemType
        var ironBars: ItemType
        var ironBlock: ItemType
        var ironBoots: ItemType
        var ironChestplate: ItemType
        var ironDoor: ItemType
        var ironHelmet: ItemType
        var ironHoe: ItemType
        var ironHorseArmor: ItemType
        var ironIngot: ItemType
        var ironLeggings: ItemType
        var ironNugget: ItemType
        var ironOre: ItemType
        var ironPickaxe: ItemType
        var ironShovel: ItemType
        var ironSword: ItemType
        var ironTrapdoor: ItemType
        var jigsaw: ItemType
        var jukebox: ItemType
        var jungleBoat: ItemType
        var jungleButton: ItemType
        var jungleChestBoat: ItemType
        var jungleDoor: ItemType
        var jungleFenceGate: ItemType
        var junglePressurePlate: ItemType
        var jungleSign: ItemType
        var jungleStairs: ItemType
        var jungleStandingSign: ItemType
        var jungleTrapdoor: ItemType
        var jungleWallSign: ItemType
        var kelp: ItemType
        var ladder: ItemType
        var lantern: ItemType
        var lapisBlock: ItemType
        var lapisLazuli: ItemType
        var lapisOre: ItemType
        var largeAmethystBud: ItemType
        var lava: ItemType
        var lavaBucket: ItemType
        var lavaCauldron: ItemType
        var lead: ItemType
        var leather: ItemType
        var leatherBoots: ItemType
        var leatherChestplate: ItemType
        var leatherHelmet: ItemType
        var leatherHorseArmor: ItemType
        var leatherLeggings: ItemType
        var leaves: ItemType
        var leaves2: ItemType
        var lectern: ItemType
        var lever: ItemType
        var lightBlock: ItemType
        var lightBlueCandle: ItemType
        var lightBlueCandleCake: ItemType
        var lightBlueDye: ItemType
        var lightBlueGlazedTerracotta: ItemType
        var lightGrayCandle: ItemType
        var lightGrayCandleCake: ItemType
        var lightGrayDye: ItemType
        var lightningRod: ItemType
        var lightWeightedPressurePlate: ItemType
        var limeCandle: ItemType
        var limeCandleCake: ItemType
        var limeDye: ItemType
        var limeGlazedTerracotta: ItemType
        var lingeringPotion: ItemType
        var litBlastFurnace: ItemType
        var litDeepslateRedstoneOre: ItemType
        var litFurnace: ItemType
        var litPumpkin: ItemType
        var litRedstoneLamp: ItemType
        var litRedstoneOre: ItemType
        var litSmoker: ItemType
        var llamaSpawnEgg: ItemType
        var lodestone: ItemType
        var lodestoneCompass: ItemType
        var log: ItemType
        var log2: ItemType
        var loom: ItemType
        var magentaCandle: ItemType
        var magentaCandleCake: ItemType
        var magentaDye: ItemType
        var magentaGlazedTerracotta: ItemType
        var magma: ItemType
        var magmaCream: ItemType
        var magmaCubeSpawnEgg: ItemType
        var mangroveBoat: ItemType
        var mangroveButton: ItemType
        var mangroveChestBoat: ItemType
        var mangroveDoor: ItemType
        var mangroveDoubleSlab: ItemType
        var mangroveFence: ItemType
        var mangroveFenceGate: ItemType
        var mangroveLeaves: ItemType
        var mangroveLog: ItemType
        var mangrovePlanks: ItemType
        var mangrovePressurePlate: ItemType
        var mangrovePropagule: ItemType
        var mangroveRoots: ItemType
        var mangroveSign: ItemType
        var mangroveSlab: ItemType
        var mangroveStairs: ItemType
        var mangroveStandingSign: ItemType
        var mangroveTrapdoor: ItemType
        var mangroveWallSign: ItemType
        var mangroveWood: ItemType
        var medicine: ItemType
        var mediumAmethystBud: ItemType
        var melonBlock: ItemType
        var melonSeeds: ItemType
        var melonSlice: ItemType
        var melonStem: ItemType
        var milkBucket: ItemType
        var minecart: ItemType
        var mobSpawner: ItemType
        var mojangBannerPattern: ItemType
        var monsterEgg: ItemType
        var mooshroomSpawnEgg: ItemType
        var mossBlock: ItemType
        var mossCarpet: ItemType
        var mossyCobblestone: ItemType
        var mossyCobblestoneStairs: ItemType
        var mossyStoneBrickStairs: ItemType
        var movingBlock: ItemType
        var mud: ItemType
        var mudBrickDoubleSlab: ItemType
        var mudBricks: ItemType
        var mudBrickSlab: ItemType
        var mudBrickStairs: ItemType
        var mudBrickWall: ItemType
        var muddyMangroveRoots: ItemType
        var muleSpawnEgg: ItemType
        var mushroomStew: ItemType
        var musicDisc11: ItemType
        var musicDisc13: ItemType
        var musicDisc5: ItemType
        var musicDiscBlocks: ItemType
        var musicDiscCat: ItemType
        var musicDiscChirp: ItemType
        var musicDiscFar: ItemType
        var musicDiscMall: ItemType
        var musicDiscMellohi: ItemType
        var musicDiscOtherside: ItemType
        var musicDiscPigstep: ItemType
        var musicDiscStal: ItemType
        var musicDiscStrad: ItemType
        var musicDiscWait: ItemType
        var musicDiscWard: ItemType
        var mutton: ItemType
        var mycelium: ItemType
        var nameTag: ItemType
        var nautilusShell: ItemType
        var netherbrick: ItemType
        var netherBrick: ItemType
        var netherBrickFence: ItemType
        var netherBrickStairs: ItemType
        var netherGoldOre: ItemType
        var netheriteAxe: ItemType
        var netheriteBlock: ItemType
        var netheriteBoots: ItemType
        var netheriteChestplate: ItemType
        var netheriteHelmet: ItemType
        var netheriteHoe: ItemType
        var netheriteIngot: ItemType
        var netheriteLeggings: ItemType
        var netheritePickaxe: ItemType
        var netheriteScrap: ItemType
        var netheriteShovel: ItemType
        var netheriteSword: ItemType
        var netherrack: ItemType
        var netherreactor: ItemType
        var netherSprouts: ItemType
        var netherStar: ItemType
        var netherWart: ItemType
        var netherWartBlock: ItemType
        var normalStoneStairs: ItemType
        var noteblock: ItemType
        var npcSpawnEgg: ItemType
        var oakBoat: ItemType
        var oakChestBoat: ItemType
        var oakSign: ItemType
        var oakStairs: ItemType
        var observer: ItemType
        var obsidian: ItemType
        var ocelotSpawnEgg: ItemType
        var ochreFroglight: ItemType
        var orangeCandle: ItemType
        var orangeCandleCake: ItemType
        var orangeDye: ItemType
        var orangeGlazedTerracotta: ItemType
        var oxidizedCopper: ItemType
        var oxidizedCutCopper: ItemType
        var oxidizedCutCopperSlab: ItemType
        var oxidizedCutCopperStairs: ItemType
        var oxidizedDoubleCutCopperSlab: ItemType
        var packedIce: ItemType
        var packedMud: ItemType
        var painting: ItemType
        var pandaSpawnEgg: ItemType
        var paper: ItemType
        var parrotSpawnEgg: ItemType
        var pearlescentFroglight: ItemType
        var phantomMembrane: ItemType
        var phantomSpawnEgg: ItemType
        var piglinBannerPattern: ItemType
        var piglinBruteSpawnEgg: ItemType
        var piglinSpawnEgg: ItemType
        var pigSpawnEgg: ItemType
        var pillagerSpawnEgg: ItemType
        var pinkCandle: ItemType
        var pinkCandleCake: ItemType
        var pinkDye: ItemType
        var pinkGlazedTerracotta: ItemType
        var piston: ItemType
        var pistonArmCollision: ItemType
        var planks: ItemType
        var podzol: ItemType
        var pointedDripstone: ItemType
        var poisonousPotato: ItemType
        var polarBearSpawnEgg: ItemType
        var polishedAndesiteStairs: ItemType
        var polishedBasalt: ItemType
        var polishedBlackstone: ItemType
        var polishedBlackstoneBrickDoubleSlab: ItemType
        var polishedBlackstoneBricks: ItemType
        var polishedBlackstoneBrickSlab: ItemType
        var polishedBlackstoneBrickStairs: ItemType
        var polishedBlackstoneBrickWall: ItemType
        var polishedBlackstoneButton: ItemType
        var polishedBlackstoneDoubleSlab: ItemType
        var polishedBlackstonePressurePlate: ItemType
        var polishedBlackstoneSlab: ItemType
        var polishedBlackstoneStairs: ItemType
        var polishedBlackstoneWall: ItemType
        var polishedDeepslate: ItemType
        var polishedDeepslateDoubleSlab: ItemType
        var polishedDeepslateSlab: ItemType
        var polishedDeepslateStairs: ItemType
        var polishedDeepslateWall: ItemType
        var polishedDioriteStairs: ItemType
        var polishedGraniteStairs: ItemType
        var poppedChorusFruit: ItemType
        var porkchop: ItemType
        var portal: ItemType
        var potato: ItemType
        var potatoes: ItemType
        var potion: ItemType
        var powderSnow: ItemType
        var powderSnowBucket: ItemType
        var poweredComparator: ItemType
        var poweredRepeater: ItemType
        var prismarine: ItemType
        var prismarineBricksStairs: ItemType
        var prismarineCrystals: ItemType
        var prismarineShard: ItemType
        var prismarineStairs: ItemType
        var pufferfish: ItemType
        var pufferfishBucket: ItemType
        var pufferfishSpawnEgg: ItemType
        var pumpkin: ItemType
        var pumpkinPie: ItemType
        var pumpkinSeeds: ItemType
        var pumpkinStem: ItemType
        var purpleCandle: ItemType
        var purpleCandleCake: ItemType
        var purpleDye: ItemType
        var purpleGlazedTerracotta: ItemType
        var purpurBlock: ItemType
        var purpurStairs: ItemType
        var quartz: ItemType
        var quartzBlock: ItemType
        var quartzBricks: ItemType
        var quartzOre: ItemType
        var quartzStairs: ItemType
        var rabbit: ItemType
        var rabbitFoot: ItemType
        var rabbitHide: ItemType
        var rabbitSpawnEgg: ItemType
        var rabbitStew: ItemType
        var rail: ItemType
        var rapidFertilizer: ItemType
        var ravagerSpawnEgg: ItemType
        var rawCopper: ItemType
        var rawCopperBlock: ItemType
        var rawGold: ItemType
        var rawGoldBlock: ItemType
        var rawIron: ItemType
        var rawIronBlock: ItemType
        var recoveryCompass: ItemType
        var redCandle: ItemType
        var redCandleCake: ItemType
        var redDye: ItemType
        var redFlower: ItemType
        var redGlazedTerracotta: ItemType
        var redMushroom: ItemType
        var redMushroomBlock: ItemType
        var redNetherBrick: ItemType
        var redNetherBrickStairs: ItemType
        var redSandstone: ItemType
        var redSandstoneStairs: ItemType
        var redstone: ItemType
        var redstoneBlock: ItemType
        var redstoneLamp: ItemType
        var redstoneOre: ItemType
        var redstoneTorch: ItemType
        var redstoneWire: ItemType
        var reinforcedDeepslate: ItemType
        var repeater: ItemType
        var repeatingCommandBlock: ItemType
        var reserved6: ItemType
        var respawnAnchor: ItemType
        var rottenFlesh: ItemType
        var saddle: ItemType
        var salmon: ItemType
        var salmonBucket: ItemType
        var salmonSpawnEgg: ItemType
        var sand: ItemType
        var sandstone: ItemType
        var sandstoneStairs: ItemType
        var sapling: ItemType
        var scaffolding: ItemType
        var sculk: ItemType
        var sculkCatalyst: ItemType
        var sculkSensor: ItemType
        var sculkShrieker: ItemType
        var sculkVein: ItemType
        var scute: ItemType
        var seagrass: ItemType
        var seaLantern: ItemType
        var seaPickle: ItemType
        var shears: ItemType
        var sheepSpawnEgg: ItemType
        var shield: ItemType
        var shroomlight: ItemType
        var shulkerBox: ItemType
        var shulkerShell: ItemType
        var shulkerSpawnEgg: ItemType
        var silverfishSpawnEgg: ItemType
        var silverGlazedTerracotta: ItemType
        var skeletonHorseSpawnEgg: ItemType
        var skeletonSpawnEgg: ItemType
        var skull: ItemType
        var skullBannerPattern: ItemType
        var slime: ItemType
        var slimeBall: ItemType
        var slimeSpawnEgg: ItemType
        var smallAmethystBud: ItemType
        var smallDripleafBlock: ItemType
        var smithingTable: ItemType
        var smoker: ItemType
        var smoothBasalt: ItemType
        var smoothQuartzStairs: ItemType
        var smoothRedSandstoneStairs: ItemType
        var smoothSandstoneStairs: ItemType
        var smoothStone: ItemType
        var snow: ItemType
        var snowball: ItemType
        var snowLayer: ItemType
        var soulCampfire: ItemType
        var soulFire: ItemType
        var soulLantern: ItemType
        var soulSand: ItemType
        var soulSoil: ItemType
        var soulTorch: ItemType
        var sparkler: ItemType
        var spawnEgg: ItemType
        var spiderEye: ItemType
        var spiderSpawnEgg: ItemType
        var splashPotion: ItemType
        var sponge: ItemType
        var sporeBlossom: ItemType
        var spruceBoat: ItemType
        var spruceButton: ItemType
        var spruceChestBoat: ItemType
        var spruceDoor: ItemType
        var spruceFenceGate: ItemType
        var sprucePressurePlate: ItemType
        var spruceSign: ItemType
        var spruceStairs: ItemType
        var spruceStandingSign: ItemType
        var spruceTrapdoor: ItemType
        var spruceWallSign: ItemType
        var spyglass: ItemType
        var squidSpawnEgg: ItemType
        var stainedGlass: ItemType
        var stainedGlassPane: ItemType
        var stainedHardenedClay: ItemType
        var standingBanner: ItemType
        var standingSign: ItemType
        var stick: ItemType
        var stickyPiston: ItemType
        var stickyPistonArmCollision: ItemType
        var stone: ItemType
        var stoneAxe: ItemType
        var stoneBlockSlab: ItemType
        var stoneBlockSlab2: ItemType
        var stoneBlockSlab3: ItemType
        var stoneBlockSlab4: ItemType
        var stonebrick: ItemType
        var stoneBrickStairs: ItemType
        var stoneButton: ItemType
        var stonecutter: ItemType
        var stonecutterBlock: ItemType
        var stoneHoe: ItemType
        var stonePickaxe: ItemType
        var stonePressurePlate: ItemType
        var stoneShovel: ItemType
        var stoneStairs: ItemType
        var stoneSword: ItemType
        var straySpawnEgg: ItemType
        var striderSpawnEgg: ItemType
        var string: ItemType
        var strippedAcaciaLog: ItemType
        var strippedBirchLog: ItemType
        var strippedCrimsonHyphae: ItemType
        var strippedCrimsonStem: ItemType
        var strippedDarkOakLog: ItemType
        var strippedJungleLog: ItemType
        var strippedMangroveLog: ItemType
        var strippedMangroveWood: ItemType
        var strippedOakLog: ItemType
        var strippedSpruceLog: ItemType
        var strippedWarpedHyphae: ItemType
        var strippedWarpedStem: ItemType
        var structureBlock: ItemType
        var structureVoid: ItemType
        var sugar: ItemType
        var sugarCane: ItemType
        var suspiciousStew: ItemType
        var sweetBerries: ItemType
        var sweetBerryBush: ItemType
        var tadpoleBucket: ItemType
        var tadpoleSpawnEgg: ItemType
        var tallgrass: ItemType
        var target: ItemType
        var tintedGlass: ItemType
        var tnt: ItemType
        var tntMinecart: ItemType
        var torch: ItemType
        var totemOfUndying: ItemType
        var trapdoor: ItemType
        var trappedChest: ItemType
        var trident: ItemType
        var tripWire: ItemType
        var tripwireHook: ItemType
        var tropicalFish: ItemType
        var tropicalFishBucket: ItemType
        var tropicalFishSpawnEgg: ItemType
        var tuff: ItemType
        var turtleEgg: ItemType
        var turtleHelmet: ItemType
        var turtleSpawnEgg: ItemType
        var twistingVines: ItemType
        var underwaterTorch: ItemType
        var undyedShulkerBox: ItemType
        var unknown: ItemType
        var unlitRedstoneTorch: ItemType
        var unpoweredComparator: ItemType
        var unpoweredRepeater: ItemType
        var verdantFroglight: ItemType
        var vexSpawnEgg: ItemType
        var villagerSpawnEgg: ItemType
        var vindicatorSpawnEgg: ItemType
        var vine: ItemType
        var wallBanner: ItemType
        var wallSign: ItemType
        var wanderingTraderSpawnEgg: ItemType
        var wardenSpawnEgg: ItemType
        var warpedButton: ItemType
        var warpedDoor: ItemType
        var warpedDoubleSlab: ItemType
        var warpedFence: ItemType
        var warpedFenceGate: ItemType
        var warpedFungus: ItemType
        var warpedFungusOnAStick: ItemType
        var warpedHyphae: ItemType
        var warpedNylium: ItemType
        var warpedPlanks: ItemType
        var warpedPressurePlate: ItemType
        var warpedRoots: ItemType
        var warpedSign: ItemType
        var warpedSlab: ItemType
        var warpedStairs: ItemType
        var warpedStandingSign: ItemType
        var warpedStem: ItemType
        var warpedTrapdoor: ItemType
        var warpedWallSign: ItemType
        var warpedWartBlock: ItemType
        var water: ItemType
        var waterBucket: ItemType
        var waterlily: ItemType
        var waxedCopper: ItemType
        var waxedCutCopper: ItemType
        var waxedCutCopperSlab: ItemType
        var waxedCutCopperStairs: ItemType
        var waxedDoubleCutCopperSlab: ItemType
        var waxedExposedCopper: ItemType
        var waxedExposedCutCopper: ItemType
        var waxedExposedCutCopperSlab: ItemType
        var waxedExposedCutCopperStairs: ItemType
        var waxedExposedDoubleCutCopperSlab: ItemType
        var waxedOxidizedCopper: ItemType
        var waxedOxidizedCutCopper: ItemType
        var waxedOxidizedCutCopperSlab: ItemType
        var waxedOxidizedCutCopperStairs: ItemType
        var waxedOxidizedDoubleCutCopperSlab: ItemType
        var waxedWeatheredCopper: ItemType
        var waxedWeatheredCutCopper: ItemType
        var waxedWeatheredCutCopperSlab: ItemType
        var waxedWeatheredCutCopperStairs: ItemType
        var waxedWeatheredDoubleCutCopperSlab: ItemType
        var weatheredCopper: ItemType
        var weatheredCutCopper: ItemType
        var weatheredCutCopperSlab: ItemType
        var weatheredCutCopperStairs: ItemType
        var weatheredDoubleCutCopperSlab: ItemType
        var web: ItemType
        var weepingVines: ItemType
        var wheat: ItemType
        var wheatSeeds: ItemType
        var whiteCandle: ItemType
        var whiteCandleCake: ItemType
        var whiteDye: ItemType
        var whiteGlazedTerracotta: ItemType
        var witchSpawnEgg: ItemType
        var witherRose: ItemType
        var witherSkeletonSpawnEgg: ItemType
        var wolfSpawnEgg: ItemType
        var wood: ItemType
        var woodenAxe: ItemType
        var woodenButton: ItemType
        var woodenDoor: ItemType
        var woodenHoe: ItemType
        var woodenPickaxe: ItemType
        var woodenPressurePlate: ItemType
        var woodenShovel: ItemType
        var woodenSlab: ItemType
        var woodenSword: ItemType
        var wool: ItemType
        var writableBook: ItemType
        var writtenBook: ItemType
        var yellowCandle: ItemType
        var yellowCandleCake: ItemType
        var yellowDye: ItemType
        var yellowFlower: ItemType
        var yellowGlazedTerracotta: ItemType
        var zoglinSpawnEgg: ItemType
        var zombieHorseSpawnEgg: ItemType
        var zombiePigmanSpawnEgg: ItemType
        var zombieSpawnEgg: ItemType
        var zombieVillagerSpawnEgg: ItemType
    }
}

external open class MolangVariableMap {
    open fun setColorRGB(variableName: String, color: Color): MolangVariableMap
    open fun setColorRGBA(variableName: String, color: Color): MolangVariableMap
    open fun setSpeedAndDirection(variableName: String, speed: Number, direction: Vector): MolangVariableMap
    open fun setVector3(variableName: String, vector: Vector): MolangVariableMap
}

external open class MusicOptions {
    open var fade: Number
    open var loop: Boolean
    open var volume: Number
}

external open class NavigationResult {
    open var isFullPath: Boolean
    open var path: Array<BlockLocation>
}

external open class NumberRange {
    open var max: Number
    open var min: Number
    open fun next(): Number
}

external open class PistonActivateEvent : BlockEvent {
    override var block: Block
    override var dimension: Dimension
    open var isExpanding: Boolean
    open var piston: BlockPistonComponent
}

external open class PistonActivateEventSignal {
    open fun subscribe(callback: (arg: PistonActivateEvent) -> Unit): (arg: PistonActivateEvent) -> Unit
    open fun unsubscribe(callback: (arg: PistonActivateEvent) -> Unit)
}

external open class Player : Entity {
    override var dimension: Dimension
    override var headLocation: Location
    override var id: String
    override var isSneaking: Boolean
    override var location: Location
    open var name: String
    override var nameTag: String
    open var onScreenDisplay: ScreenDisplay
    override var rotation: XYRotation
    override var scoreboard: ScoreboardIdentity
    open var selectedSlot: Number
    override var target: Entity
    override var velocity: Vector
    override var viewVector: Vector
    override fun addEffect(effectType: EffectType, duration: Number, amplifier: Number, showParticles: Boolean)
    override fun addTag(tag: String): Boolean
    override fun getBlockFromViewVector(options: BlockRaycastOptions): Block
    override fun getComponent(componentId: String): IEntityComponent
    override fun getComponents(): Array<IEntityComponent>
    override fun getDynamicProperty(identifier: String): dynamic /* Boolean | Number | String */
    override fun getEffect(effectType: EffectType): Effect
    override fun getEntitiesFromViewVector(options: EntityRaycastOptions): Array<Entity>
    open fun getItemCooldown(itemCategory: String): Number
    override fun getTags(): Array<String>
    override fun hasComponent(componentId: String): Boolean
    override fun hasTag(tag: String): Boolean
    override fun kill()
    open fun playSound(soundID: String, soundOptions: SoundOptions = definedExternally)
    override fun removeDynamicProperty(identifier: String): Boolean
    override fun removeTag(tag: String): Boolean
    override fun runCommand(commandString: String): Any
    override fun runCommandAsync(commandString: String): Promise<CommandResult>
    override fun setDynamicProperty(identifier: String, value: Boolean)
    override fun setDynamicProperty(identifier: String, value: Number)
    override fun setDynamicProperty(identifier: String, value: String)
    override fun setRotation(degreesX: Number, degreesY: Number)
    override fun setVelocity(velocity: Vector)
    open fun startItemCooldown(itemCategory: String, tickDuration: Number)
    override fun teleport(location: Location, dimension: Dimension, xRotation: Number, yRotation: Number, keepVelocity: Boolean)
    override fun teleportFacing(location: Location, dimension: Dimension, facingLocation: Location, keepVelocity: Boolean)
    override fun triggerEvent(eventName: String)
}

external open class PlayerInventoryComponentContainer : InventoryComponentContainer {
    override var emptySlotsCount: Number
    override var size: Number
    override fun addItem(itemStack: ItemStack)
    override fun getItem(slot: Number): ItemStack
    override fun setItem(slot: Number, itemStack: ItemStack)
    override fun swapItems(slot: Number, otherSlot: Number, otherContainer: Container): Boolean
    override fun transferItem(fromSlot: Number, toSlot: Number, toContainer: Container): Boolean
}

typealias PlayerIterator = Iterable<Player>

external open class PlayerJoinEvent {
    open var player: Player
}

external open class PlayerJoinEventSignal {
    open fun subscribe(callback: (arg: PlayerJoinEvent) -> Unit): (arg: PlayerJoinEvent) -> Unit
    open fun unsubscribe(callback: (arg: PlayerJoinEvent) -> Unit)
}

external open class PlayerLeaveEvent {
    open var playerName: String
}

external open class PlayerLeaveEventSignal {
    open fun subscribe(callback: (arg: PlayerLeaveEvent) -> Unit): (arg: PlayerLeaveEvent) -> Unit
    open fun unsubscribe(callback: (arg: PlayerLeaveEvent) -> Unit)
}

external open class ProjectileHitEvent {
    open var blockHit: BlockHitInformation
    open var dimension: Dimension
    open var entityHit: EntityHitInformation
    open var hitVector: Vector
    open var location: Location
    open var projectile: Entity
    open var source: Entity
}

external open class ProjectileHitEventSignal {
    open fun subscribe(callback: (arg: ProjectileHitEvent) -> Unit): (arg: ProjectileHitEvent) -> Unit
    open fun unsubscribe(callback: (arg: ProjectileHitEvent) -> Unit)
}

external open class PropertyRegistry {
    open fun registerEntityTypeDynamicProperties(propertiesDefinition: DynamicPropertiesDefinition, entityType: EntityType)
    open fun registerWorldDynamicProperties(propertiesDefinition: DynamicPropertiesDefinition)
}

external open class Scoreboard {
    open fun getObjective(objectiveId: String): ScoreboardObjective
    open fun getObjectives(): Array<ScoreboardObjective>
    open fun getParticipants(): Array<ScoreboardIdentity>
}

external open class ScoreboardIdentity {
    open var displayName: String
    open var id: Number
    open var type: ScoreboardIdentityType
    open fun getEntity(): Entity
}

external open class ScoreboardObjective {
    open var displayName: String
    open var id: String
    open fun getParticipants(): Array<ScoreboardIdentity>
    open fun getScore(participant: ScoreboardIdentity): Number
    open fun getScores(): Array<ScoreboardScoreInfo>
}

external open class ScoreboardScoreInfo {
    open var participant: ScoreboardIdentity
    open var score: Number
}

external open class ScreenDisplay {
    open fun clearTitle()
    open fun setActionBar(text: String)
    open fun setTitle(title: String, options: TitleDisplayOptions = definedExternally)
    open fun updateSubtitle(subtitle: String)
}

external open class Seat {
    open var lockRiderRotation: Number
    open var maxRiderCount: Number
    open var minRiderCount: Number
    open var position: Location
}

external open class SoundOptions {
    open var location: Location
    open var pitch: Number
    open var volume: Number
}

external open class StringBlockProperty : IBlockProperty {
    override var name: String
    open var validValues: Array<String>
    open var value: String
}

external open class TickEvent {
    open var currentTick: Number
    open var deltaTime: Number
}

external open class TickEventSignal {
    open fun subscribe(callback: (arg: TickEvent) -> Unit): (arg: TickEvent) -> Unit
    open fun unsubscribe(callback: (arg: TickEvent) -> Unit)
}

external open class TitleDisplayOptions {
    open var fadeInSeconds: Number
    open var fadeOutSeconds: Number
    open var staySeconds: Number
    open var subtitle: String
}

external open class Trigger(eventName: String) {
    open var eventName: String
}

external open class Vector(x: Number, y: Number, z: Number) {
    open var x: Number
    open var y: Number
    open var z: Number
    open fun equals(other: Vector): Boolean
    open fun length(): Number
    open fun normalized(): Vector

    companion object {
        var back: Vector
        var down: Vector
        var forward: Vector
        var left: Vector
        var one: Vector
        var right: Vector
        var up: Vector
        var zero: Vector
        fun add(a: Vector, b: Vector): Vector
        fun cross(a: Vector, b: Vector): Vector
        fun distance(a: Vector, b: Vector): Number
        fun divide(a: Vector, b: Number): Vector
        fun divide(a: Vector, b: Vector): Vector
        fun lerp(a: Vector, b: Vector, t: Number): Vector
        fun max(a: Vector, b: Vector): Vector
        fun min(a: Vector, b: Vector): Vector
        fun multiply(a: Vector, b: Number): Vector
        fun multiply(a: Vector, b: Vector): Vector
        fun slerp(a: Vector, b: Vector, s: Number): Vector
        fun subtract(a: Vector, b: Vector): Vector
    }
}

external open class WeatherChangeEvent {
    open var dimension: String
    open var lightning: Boolean
    open var raining: Boolean
}

external open class WeatherChangeEventSignal {
    open fun subscribe(callback: (arg: WeatherChangeEvent) -> Unit): (arg: WeatherChangeEvent) -> Unit
    open fun unsubscribe(callback: (arg: WeatherChangeEvent) -> Unit)
}

external open class World {
    open var events: Events
    open var scoreboard: Scoreboard
    open fun getDimension(dimensionId: String): Dimension
    open fun getDynamicProperty(identifier: String): dynamic /* Boolean | Number | String */
    open fun getPlayers(options: EntityQueryOptions = definedExternally): PlayerIterator
    open fun playMusic(trackID: String, musicOptions: MusicOptions = definedExternally)
    open fun playSound(soundID: String, soundOptions: SoundOptions = definedExternally)
    open fun queueMusic(trackID: String, musicOptions: MusicOptions = definedExternally)
    open fun removeDynamicProperty(identifier: String): Boolean
    open fun setDynamicProperty(identifier: String, value: Boolean)
    open fun setDynamicProperty(identifier: String, value: Number)
    open fun setDynamicProperty(identifier: String, value: String)
    open fun stopMusic()
}

external open class WorldInitializeEvent {
    open var propertyRegistry: PropertyRegistry
}

external open class WorldInitializeEventSignal {
    open fun subscribe(callback: (arg: WorldInitializeEvent) -> Unit): (arg: WorldInitializeEvent) -> Unit
    open fun unsubscribe(callback: (arg: WorldInitializeEvent) -> Unit)
}

external open class XYRotation {
    open var x: Number
    open var y: Number
}

external var TicksPerSecond: Any

external var world: World