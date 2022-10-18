package dk.rigqx.battlepass.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCreator {
	@Deprecated
	public static ItemStack itemFromName(String paramString) {
		ItemStack itemStack = getPlayerSkullItem();
		return itemWithName(itemStack, paramString);
	}

	@Deprecated
	public static ItemStack itemWithName(ItemStack paramItemStack, String paramString) {
		notNull(paramItemStack, "item");
		notNull(paramString, "name");
		return Bukkit.getUnsafe().modifyItemStack(paramItemStack, "{SkullOwner:\"" + paramString + "\"}");
	}

	public static ItemStack itemFromUuid(UUID paramUUID) {
		ItemStack itemStack = getPlayerSkullItem();
		return itemWithUuid(itemStack, paramUUID);
	}

	public static ItemStack itemWithUuid(ItemStack paramItemStack, UUID paramUUID) {
		notNull(paramItemStack, "item");
		notNull(paramUUID, "id");
		SkullMeta skullMeta = (SkullMeta)paramItemStack.getItemMeta();
		if (Bukkit.getPlayer(paramUUID) != null) {
			skullMeta.setOwner(Bukkit.getPlayer(paramUUID).getName());
		} else {
			return getPlayerSkullItem();
		}
		paramItemStack.setItemMeta((ItemMeta)skullMeta);
		return paramItemStack;
	}

	public static ItemStack itemFromUrl(String paramString) {
		ItemStack itemStack = getPlayerSkullItem();
		return itemWithUrl(itemStack, paramString);
	}

	public static ItemStack itemWithUrl(ItemStack paramItemStack, String paramString) {
		notNull(paramItemStack, "item");
		notNull(paramString, "url");
		return itemWithBase64(paramItemStack, urlToBase64(paramString));
	}

	public static ItemStack itemFromBase64(String paramString) {
		ItemStack itemStack = getPlayerSkullItem();
		return itemWithBase64(itemStack, paramString);
	}

	public static ItemStack itemWithBase64(ItemStack paramItemStack, String paramString) {
		notNull(paramItemStack, "item");
		notNull(paramString, "base64");
		UUID uUID = new UUID(paramString.hashCode(), paramString.hashCode());
		return Bukkit.getUnsafe().modifyItemStack(paramItemStack, "{SkullOwner:{Id:\"" + uUID + "\",Properties:{textures:[{Value:\"" + paramString + "\"}]}}}");
	}

	@Deprecated
	public static void blockWithName(Block paramBlock, String paramString) {
		notNull(paramBlock, "block");
		notNull(paramString, "name");
		setBlockType(paramBlock);
		((Skull)paramBlock.getState()).setOwner(paramString);
	}

	public static void blockWithUuid(Block paramBlock, UUID paramUUID) {
		notNull(paramBlock, "block");
		notNull(paramUUID, "id");
		setBlockType(paramBlock);
		((Skull)paramBlock.getState()).setOwner(Bukkit.getOfflinePlayer(paramUUID).getName());
	}

	public static void blockWithUrl(Block paramBlock, String paramString) {
		notNull(paramBlock, "block");
		notNull(paramString, "url");
		blockWithBase64(paramBlock, urlToBase64(paramString));
	}

	public static void blockWithBase64(Block paramBlock, String paramString) {
		notNull(paramBlock, "block");
		notNull(paramString, "base64");
		UUID uUID = new UUID(paramString.hashCode(), paramString.hashCode());
		String str = String.format("%d %d %d %s", new Object[] { Integer.valueOf(paramBlock.getX()),
				Integer.valueOf(paramBlock.getY()),
				Integer.valueOf(paramBlock.getZ()), "{Owner:{Id:\"" + uUID + "\",Properties:{textures:[{Value:\"" + paramString + "\"}]}}}" });
	}

	private static ItemStack getPlayerSkullItem() {
		return new ItemStack(Material.valueOf("SKULL_ITEM"), 1, (short)3);
	}

	private static void setBlockType(Block paramBlock) {
		try {
			paramBlock.setType(Material.valueOf("PLAYER_HEAD"), false);
		} catch (IllegalArgumentException illegalArgumentException) {
			paramBlock.setType(Material.valueOf("SKULL"), false);
		}
	}

	private static void notNull(Object paramObject, String paramString) {
		if (paramObject == null)
			throw new NullPointerException(paramString + " should not be null!");
	}

	private static String urlToBase64(String paramString) {
		URI uRI;
		try {
			uRI = new URI(paramString);
		} catch (URISyntaxException uRISyntaxException) {
			throw new RuntimeException(uRISyntaxException);
		}
		String str = "{\"textures\":{\"SKIN\":{\"url\":\"" + uRI.toString() + "\"}}}";
		return Base64.getEncoder().encodeToString(str.getBytes());
	}
}