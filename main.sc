import .raydEngine.use
import HID
let vk = (import .volk)

inline vkcheck (result)
    switch result
    case vk.Result.VK_SUCCESS
        return;
    case vk.Result.VK_NOT_READY
        print "A fence or query has not yet completed"
    case vk.Result.VK_TIMEOUT
        print "A wait operation has not completed in the specified time"
    case vk.Result.VK_EVENT_SET
        print "An event is signaled"
    case vk.Result.VK_EVENT_RESET
        print "An event is unsignaled"
    case vk.Result.VK_INCOMPLETE
        print "A return array was too small for the result"
    case vk.Result.VK_SUBOPTIMAL_KHR
        print "A swapchain no longer matches the surface properties exactly, but can still be used to present to the surface successfully."
    # case vk.Result.VK_THREAD_IDLE_KHR
    #     print "A deferred operation is not complete but there is currently no work for this thread to do at the time of this call."
    # case vk.Result.VK_THREAD_DONE_KHR
    #     print "A deferred operation is not complete but there is no work remaining to assign to additional threads."
    # case vk.Result.VK_OPERATION_DEFERRED_KHR
    #     print "A deferred operation was requested and at least some of the work was deferred."
    # case vk.Result.VK_OPERATION_NOT_DEFERRED_KHR
    #     print "A deferred operation was requested and no operations were deferred."
    # case vk.Result.VK_PIPELINE_COMPILE_REQUIRED_EXT
    #     print "A requested pipeline creation would have required compilation, but the application requested compilation to not be performed."
    # Error codes
    case vk.Result.VK_ERROR_OUT_OF_HOST_MEMORY
        assert false "A host memory allocation has failed."
    case vk.Result.VK_ERROR_OUT_OF_DEVICE_MEMORY
        assert false "A device memory allocation has failed."
    case vk.Result.VK_ERROR_INITIALIZATION_FAILED
        assert false "Initialization of an object could not be completed for implementation-specific reasons."
    case vk.Result.VK_ERROR_DEVICE_LOST
        assert false "The logical or physical device has been lost. See Lost Device"
    case vk.Result.VK_ERROR_MEMORY_MAP_FAILED
        assert false "Mapping of a memory object has failed."
    case vk.Result.VK_ERROR_LAYER_NOT_PRESENT
        assert false "A requested layer is not present or could not be loaded."
    case vk.Result.VK_ERROR_EXTENSION_NOT_PRESENT
        assert false "A requested extension is not supported."
    case vk.Result.VK_ERROR_FEATURE_NOT_PRESENT
        assert false "A requested feature is not supported."
    case vk.Result.VK_ERROR_INCOMPATIBLE_DRIVER
        assert false "The requested version of Vulkan is not supported by the driver or is otherwise incompatible for implementation-specific reasons."
    case vk.Result.VK_ERROR_TOO_MANY_OBJECTS
        assert false "Too many objects of the type have already been created."
    case vk.Result.VK_ERROR_FORMAT_NOT_SUPPORTED
        assert false "A requested format is not supported on this device."
    case vk.Result.VK_ERROR_FRAGMENTED_POOL
        assert false "A pool allocation has failed due to fragmentation of the pool’s memory. This must only be returned if no attempt to allocate host or device memory was made to accommodate the new allocation. This should be returned in preference to VK_ERROR_OUT_OF_POOL_MEMORY, but only if the implementation is certain that the pool allocation failure was due to fragmentation."
    case vk.Result.VK_ERROR_SURFACE_LOST_KHR
        assert false "A surface is no longer available."
    case vk.Result.VK_ERROR_NATIVE_WINDOW_IN_USE_KHR
        assert false "The requested window is already in use by Vulkan or another API in a manner which prevents it from being used again."
    case vk.Result.VK_ERROR_OUT_OF_DATE_KHR
        assert false "A surface has changed in such a way that it is no longer compatible with the swapchain, and further presentation requests using the swapchain will fail. Applications must query the new surface properties and recreate their swapchain if they wish to continue presenting to the surface."
    case vk.Result.VK_ERROR_INCOMPATIBLE_DISPLAY_KHR
        assert false "The display used by a swapchain does not use the same presentable image layout, or is incompatible in a way that prevents sharing an image."
    case vk.Result.VK_ERROR_INVALID_SHADER_NV
        assert false "One or more shaders failed to compile or link. More details are reported back to the application via VK_EXT_debug_report if enabled."
    case vk.Result.VK_ERROR_OUT_OF_POOL_MEMORY
        assert false "A pool memory allocation has failed. This must only be returned if no attempt to allocate host or device memory was made to accommodate the new allocation. If the failure was definitely due to fragmentation of the pool, VK_ERROR_FRAGMENTED_POOL should be returned instead."
    case vk.Result.VK_ERROR_INVALID_EXTERNAL_HANDLE
        assert false "An external handle is not a valid handle of the specified type."
    case vk.Result.VK_ERROR_FRAGMENTATION
        assert false "A descriptor pool creation has failed due to fragmentation."
    # case vk.Result.VK_ERROR_INVALID_DEVICE_ADDRESS_EXT
    #     assert false "A buffer creation failed because the requested address is not available."
    case vk.Result.VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS
        assert false "A buffer creation or memory allocation failed because the requested address is not available. A shader group handle assignment failed because the requested shader group handle information is no longer valid."
    case vk.Result.VK_ERROR_FULL_SCREEN_EXCLUSIVE_MODE_LOST_EXT
        assert false "An operation on a swapchain created with VK_FULL_SCREEN_EXCLUSIVE_APPLICATION_CONTROLLED_EXT failed as it did not have exlusive full-screen access. This may occur due to implementation-dependent reasons, outside of the application’s control."
    case vk.Result.VK_ERROR_UNKNOWN
        assert false "An unknown error has occurred; either the application has provided invalid input, or an implementation failure has occurred."
    default
        assert false "unknown error"

# ================================================================================

HID.init (HID.WindowOptions (visible? = true)) (HID.GfxAPI.WebGPU)
vkcheck
    vk.volkInitialize;

while (not (HID.window.received-quit-event?))
    HID.window.poll-events;
